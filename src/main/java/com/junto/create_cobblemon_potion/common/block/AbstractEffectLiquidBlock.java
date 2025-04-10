package com.junto.create_cobblemon_potion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

/**
 * 抽象基类，用于具有实体接触效果的流体方块。
 * 将效果应用逻辑委托给子类实现。
 */
public abstract class AbstractEffectLiquidBlock extends LiquidBlock {

    // Store the fluid supplier if needed by subclasses, though maybe not necessary now
    protected final Supplier<? extends FlowingFluid> fluidSupplier;

    protected AbstractEffectLiquidBlock(Supplier<? extends FlowingFluid> pFluidSupplier, BlockBehaviour.Properties pProperties) {
        super(pFluidSupplier.get(), pProperties); // Pass the actual fluid to the super constructor
        this.fluidSupplier = pFluidSupplier; // Store the supplier just in case
    }

    @Override
    public final void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        // Final method to enforce checks before applying effect
        if (!pLevel.isClientSide && pEntity instanceof LivingEntity livingEntity) {
            // Delegate the actual effect application to the specific subclass
            applyEffect(livingEntity, pLevel, pPos);
        }
        // Call super method for default liquid block behavior
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    /**
     * 由具体的流体方块子类实现，用于应用特定的药水效果。
     * @param entity The LivingEntity inside the fluid
     * @param level The level
     * @param pos The position of the fluid block
     */
    protected abstract void applyEffect(LivingEntity entity, Level level, BlockPos pos);
}