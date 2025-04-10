package com.junto.create_cobblemon_potion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction; // Needed for state definition
import net.minecraft.server.level.ServerLevel; // Needed for randomTick
import net.minecraft.util.RandomSource; // Needed for randomTick
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block; // Needed for state definition
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition; // Needed for state definition
import net.minecraft.world.level.block.state.properties.BlockStateProperties; // Common properties
import net.minecraft.world.level.block.state.properties.IntegerProperty; // For strength level
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState; // Needed for default state

import java.util.function.Supplier;

public abstract class AbstractEffectLiquidBlock extends LiquidBlock {

    // --- 方块状态定义 ---
    // 定义一个整数属性来表示药水强度/等级。例如 0=失效, 1=弱, 2=中, 3=强
    // 你需要根据你的药水种类决定最大等级是多少。这里假设最多 3 级有效。
    public static final int MAX_STRENGTH = 255;
    public static final IntegerProperty STRENGTH = IntegerProperty.create("strength", 0, MAX_STRENGTH);

    protected final Supplier<? extends FlowingFluid> fluidSupplier;
    private final int initialStrength; // 存储这个方块类型对应的初始强度
    private final Supplier<BlockState> degradedStateSupplier; // 强度降为0时变成什么方块

    /**
     * 修改构造函数以接受初始强度和降级后的方块状态
     * @param pFluidSupplier 流体 Supplier
     * @param pProperties 方块属性
     * @param initialStrength 这个药水类型对应的初始强度 (1 到 MAX_STRENGTH)
     * @param degradedStateSupplier 当强度降为0时，应该变成哪个方块的默认状态 (例如，普通水方块 Blocks.WATER.defaultBlockState())
     */
    protected AbstractEffectLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, BlockBehaviour.Properties pProperties, int initialStrength, Supplier<BlockState> degradedStateSupplier) {
        super(pFluidSupplier.get(), pProperties);
        this.fluidSupplier = pFluidSupplier;
        this.initialStrength = Math.min(Math.max(initialStrength, 1), MAX_STRENGTH); // 确保初始强度在有效范围内
        this.degradedStateSupplier = degradedStateSupplier; // 存储降级后的状态

        // --- 设置默认方块状态 ---
        // 设置默认强度为提供的初始强度，并继承流体的 LEVEL 状态
        FluidState fluidstate = pFluidSupplier.get().getSource(false); // Get default fluid state
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LEVEL, Integer.valueOf(fluidstate.getAmount())) // Set default fluid level
                .setValue(STRENGTH, this.initialStrength)); // Set default strength
    }

    /**
     * 创建方块状态定义，包含我们自定义的 STRENGTH 属性和原有的 LEVEL 属性。
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        // 添加原有的 LEVEL 属性 (来自 LiquidBlock) 和我们自定义的 STRENGTH 属性
        pBuilder.add(LEVEL, STRENGTH);
    }

    /**
     * 让方块接收随机刻。
     * @param pState 当前方块状态
     * @return true 如果强度大于0，则需要随机刻来处理衰减
     */
    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        // 只有当药水还有强度时，才需要随机刻来衰减
        return pState.getValue(STRENGTH) > 0;
    }

    /**
     * 处理随机刻。
     * @param pState 当前状态
     * @param pLevel 服务器世界
     * @param pPos 位置
     * @param pRandom 随机源
     */
    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int currentStrength = pState.getValue(STRENGTH);

        // 如果当前还有强度，则尝试降低强度
        if (currentStrength > 0) {
            // --- 控制衰减速率 (可选) ---
            // 默认情况下，每次随机刻都会衰减。
            // 如果想让衰减变慢，可以加入随机判断。例如，只有 1/4 的几率衰减：
//             if (pRandom.nextInt(4) != 0) {
//                 return; // 提前退出，本次不衰减
//             }

            int nextStrength = currentStrength - 1;

            if (nextStrength > 0) {
                // 如果衰减后还有强度，则更新方块状态为新的强度
                pLevel.setBlock(pPos, pState.setValue(STRENGTH, nextStrength), Block.UPDATE_CLIENTS); // UPDATE_CLIENTS 确保客户端也能看到变化（如果需要）
            } else {
                // 如果强度降为 0，则变成指定的降级状态 (例如水)
                // 获取降级后的目标方块状态
                BlockState degradedState = this.degradedStateSupplier.get();
                // 检查目标状态是否也有 LEVEL 属性 (理论上 LiquidBlock 都有)
                if (degradedState.hasProperty(LEVEL)) {
                    // 从当前状态 pState 获取 LEVEL 值，并设置到降级后的状态中
                    int currentLevel = pState.getValue(LEVEL);
                    degradedState = degradedState.setValue(LEVEL, currentLevel);
                }
                // 使用保留了 LEVEL 的降级状态替换当前方块
                pLevel.setBlock(pPos, degradedState, Block.UPDATE_CLIENTS);
            }
        }
        // 如果 currentStrength 已经是 0，则不做任何事 (理论上 isRandomlyTicking 会阻止这种情况)
    }


    /**
     * 覆盖 entityInside，根据当前强度应用效果。
     */
    @Override
    public final void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide && pEntity instanceof LivingEntity livingEntity) {
            int currentStrength = pState.getValue(STRENGTH);
            if (currentStrength > 0) { // 只有还有强度时才应用效果
                // 将当前强度传递给子类
                applyEffect(livingEntity, pLevel, pPos, currentStrength);
            }
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    /**
     * 修改抽象方法，让子类知道当前的药水强度。
     * @param entity The LivingEntity inside the fluid
     * @param level The level
     * @param pos The position of the fluid block
     * @param strength The current strength level (1 to MAX_STRENGTH)
     */
    protected abstract void applyEffect(LivingEntity entity, Level level, BlockPos pos, int strength);

}