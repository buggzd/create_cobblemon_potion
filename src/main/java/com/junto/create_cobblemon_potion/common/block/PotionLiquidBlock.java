package com.junto.create_cobblemon_potion.common.block;

import com.junto.create_cobblemon_potion.core.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks; // Import Blocks for water state
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class PotionLiquidBlock extends AbstractEffectLiquidBlock {

    // 定义这种药水的初始强度和降级后的状态
    public static final int INITIAL_STRENGTH = 1; // 普通药水假设只有1级强度
    // 降级后变回低级药水
    private static final Supplier<net.minecraft.world.level.block.state.BlockState> DEGRADED_STATE =
            () -> BlockRegistry.MEDICINAL_BREW_BLOCK.get().defaultBlockState().setValue(STRENGTH, MedicinalBrewLiquidBlock.INITIAL_STRENGTH); // Degrade to Potion Block at its initial strength

    public PotionLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, BlockBehaviour.Properties pProperties) {
        // 调用父类构造函数，传入初始强度和降级状态
        super(pFluidSupplier, pProperties, INITIAL_STRENGTH, DEGRADED_STATE);
    }

    @Override
    protected void applyEffect(LivingEntity entity, Level level, BlockPos pos, int strength) {
        // 普通药水只有 1 级强度，所以直接应用 Regeneration I
        // 如果药水有多个强度等级，可以在这里用 if/switch 判断 strength 的值
        if (strength >= 1) { // 确保至少有1级强度
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, true, true));
        }
    }
}