package com.junto.create_cobblemon_potion.common.block;

import com.junto.create_cobblemon_potion.core.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MaxPotionLiquidBlock extends AbstractEffectLiquidBlock {


    public static final int INITIAL_STRENGTH = 15;
    private static final Supplier<net.minecraft.world.level.block.state.BlockState> DEGRADED_STATE =
            () -> BlockRegistry.HYPER_POTION_BLOCK.get().defaultBlockState().setValue(STRENGTH, HyperPotionLiquidBlock.INITIAL_STRENGTH); // Degrade to Potion Block at its initial strength


    public MaxPotionLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, Properties pProperties) {
        super(pFluidSupplier, pProperties, INITIAL_STRENGTH, DEGRADED_STATE);
    }

    @Override
    protected void applyEffect(LivingEntity entity, Level level, BlockPos pos, int strength) {
//        if (strength == 2) { // 强度为 2 时，效果强 (Regen II)
//            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, true, true));
//        } else if (strength == 1) { // 强度为 1 时，效果弱 (Regen I)
//            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, true, true));
//        }
        if (strength > 0){
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 3, false, true, true));
        }
        // strength 为 0 时不会调用此方法
    }
}