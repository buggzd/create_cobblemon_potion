package com.junto.create_cobblemon_potion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MedicinalBrewLiquidBlock extends AbstractEffectLiquidBlock {

    // 定义这种药水的初始强度和降级后的状态
    public static final int INITIAL_STRENGTH = 240; // 普通药水假设只有1级强度
    // 降级后变回普通水方块
    private static final Supplier<net.minecraft.world.level.block.state.BlockState> DEGRADED_STATE = Blocks.WATER::defaultBlockState;

    public MedicinalBrewLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, Properties pProperties) {
        // 调用父类构造函数，传入初始强度和降级状态
        super(pFluidSupplier, pProperties, INITIAL_STRENGTH, DEGRADED_STATE);
    }

    @Override
    protected void applyEffect(LivingEntity entity, Level level, BlockPos pos, int strength) {

    }
}