package com.junto.create_cobblemon_potion.common.fluids;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.function.Consumer;

/**
 * 自定义的 FluidType 基类，用于简化流体类型的创建，特别是客户端渲染部分。
 * 直接存储纹理、颜色等信息。
 */
public class BaseFluidType extends FluidType {

    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    private final ResourceLocation overlayTexture; // 可选
    private final int tintColor;
    private final Vector3f fogColor;

    /**
     * 构造函数
     * @param stillTexture 静止纹理 RL
     * @param flowingTexture 流动纹理 RL
     * @param overlayTexture 覆盖纹理 RL (可为 null)
     * @param tintColor ARGB 格式的染色值
     * @param fogColor RGB 格式的雾颜色 (0.0f - 1.0f)
     * @param properties FluidType 的基础属性
     */
    public BaseFluidType(final ResourceLocation stillTexture, final ResourceLocation flowingTexture, @Nullable final ResourceLocation overlayTexture,
                         final int tintColor, final Vector3f fogColor, final Properties properties) {
        super(properties);
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.overlayTexture = overlayTexture;
        this.tintColor = tintColor;
        this.fogColor = fogColor;
    }

    // --- Getters for client-side registration ---
    // 提供 public getter 方法，以便客户端事件可以访问这些属性

    public ResourceLocation getStillTextureRL() { // Renamed getter slightly for clarity
        return stillTexture;
    }

    public ResourceLocation getFlowingTextureRL() { // Renamed getter slightly for clarity
        return flowingTexture;
    }

    public int getTintColor() {
        return tintColor;
    }

    @Nullable
    public ResourceLocation getOverlayTextureRL() { // Renamed getter slightly for clarity
        return overlayTexture;
    }

    public Vector3f getFogColor() {
        return fogColor;
    }

    // initializeClient 方法已完全移除
}