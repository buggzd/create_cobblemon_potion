package com.junto.create_cobblemon_potion.client;

// --- Keep all other imports the same ---
import com.create_cobblemon_potion;
import com.junto.create_cobblemon_potion.common.fluids.BaseFluidType;
import com.junto.create_cobblemon_potion.core.registry.FluidRegistry;
import com.junto.create_cobblemon_potion.core.registry.FluidTypeRegistry;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType; // Import FluidType
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import javax.annotation.Nullable; // Correct import for Nullable

// --- Use fml.common.Mod for the annotation ---
@EventBusSubscriber(modid = create_cobblemon_potion.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) { // Use the correct event type
        registerFluidTypeExtension(event, FluidTypeRegistry.MEDICINAL_BREW_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.POTION_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.SUPER_POTION_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.HYPER_POTION_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.MAX_POTION_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.FULL_RESTORE_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.ETHER_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.MAX_ETHER_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.ELIXIR_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.MAX_ELIXIR_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.ANTIDOTE_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.AWAKENING_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.BURN_HEAL_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.ICE_HEAL_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.PARALYZE_HEAL_FLUID_TYPE.get());
        registerFluidTypeExtension(event, FluidTypeRegistry.FULL_HEAL_FLUID_TYPE.get());

        // ... other types ...
    }

    /**
     * 辅助方法，用于为单个 FluidType 注册客户端扩展。
     * *** CHANGED: Parameter type is now FluidType ***
     */
    private static void registerFluidTypeExtension(RegisterClientExtensionsEvent event, FluidType type) { // Changed BaseFluidType to FluidType
        // ** This instanceof check is now necessary and correct **
        if (type instanceof BaseFluidType baseFluidType) {
            // *** The call inside now correctly passes 'type' which is a FluidType ***
            event.registerFluidType(new IClientFluidTypeExtensions() {
                            @Override
                            public ResourceLocation getStillTexture() {
                                return baseFluidType.getStillTextureRL();
                            }

                            @Override
                            public ResourceLocation getFlowingTexture() {
                                return baseFluidType.getFlowingTextureRL();
                            }

                            @Override
                            public @Nullable ResourceLocation getOverlayTexture() {
                                return baseFluidType.getOverlayTextureRL();
                            }

                            @Override
                            public int getTintColor() {
                                return baseFluidType.getTintColor();
                            }

                            @Override
                            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                                return baseFluidType.getFogColor();
                            }
                            @Override
                            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                                RenderSystem.setShaderFogStart(1f);
                                RenderSystem.setShaderFogEnd(6f);
                            }
                        }, type);
        }
        // Optional: Add an else block here to log a warning if a FluidType was passed
        // that wasn't an instance of BaseFluidType, though it shouldn't happen with your current setup.
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MEDICINAL_BREW_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MEDICINAL_BREW_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.POTION_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.POTION_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.SUPER_POTION_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.SUPER_POTION_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.HYPER_POTION_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.HYPER_POTION_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MAX_POTION_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MAX_POTION_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.FULL_RESTORE_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.FULL_RESTORE_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ETHER_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ETHER_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MAX_ETHER_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MAX_ETHER_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ELIXIR_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ELIXIR_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MAX_ELIXIR_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MAX_ELIXIR_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ANTIDOTE_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ANTIDOTE_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.AWAKENING_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.AWAKENING_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.BURN_HEAL_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.BURN_HEAL_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ICE_HEAL_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.ICE_HEAL_FLOWING.get(), RenderType.translucent());


            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.PARALYZE_HEAL_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.PARALYZE_HEAL_FLOWING.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.FULL_HEAL_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.FULL_HEAL_FLOWING.get(), RenderType.translucent());

            // ... other types ...
        });
    }
}