package com.junto.create_cobblemon_potion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class PotionLiquidBlock extends AbstractEffectLiquidBlock {

    public PotionLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, BlockBehaviour.Properties pProperties) {
        super(pFluidSupplier, pProperties);
    }

    @Override
    protected void applyEffect(LivingEntity entity, Level level, BlockPos pos) {
        // Apply Regeneration I for 3 seconds
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, true, true));
    }
}