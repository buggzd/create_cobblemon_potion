package com.junto.create_cobblemon_potion.common.block;

import com.junto.create_cobblemon_potion.core.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class SuperPotionLiquidBlock extends AbstractEffectLiquidBlock {

    public static final int INITIAL_STRENGTH = 60; // 好伤药假设初始强度 2
    // 降级后变成普通药水方块 (需要 BlockRegistry 已经注册了 POTION_BLOCK)
    // !! 注意：这里可能产生加载顺序问题，最好使用 Supplier !!
    private static final Supplier<net.minecraft.world.level.block.state.BlockState> DEGRADED_STATE =
            () -> BlockRegistry.POTION_BLOCK.get().defaultBlockState().setValue(STRENGTH, PotionLiquidBlock.INITIAL_STRENGTH); // Degrade to Potion Block at its initial strength


    public SuperPotionLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, BlockBehaviour.Properties pProperties) {
        super(pFluidSupplier, pProperties, INITIAL_STRENGTH, DEGRADED_STATE);
    }

    @Override
    protected void applyEffect(LivingEntity entity, Level level, BlockPos pos, int strength) {
//        if (strength == 2) { // 强度为 2 时，效果强 (Regen II)
//            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, true, true));
//        } else if (strength == 1) { // 强度为 1 时，效果弱 (Regen I)
//            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, true, true));
//        }
        if (strength>0){
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, true, true));
        }
        // strength 为 0 时不会调用此方法
    }
}