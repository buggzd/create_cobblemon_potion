package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import com.junto.create_cobblemon_potion.common.fluids.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class FluidTypeRegistry {
    // --- 定义纹理位置常量 (保持不变) ---
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_flow");
    public static final ResourceLocation POTION_OVERLAY_RL = null; // 示例：没有覆盖纹理
    // 创建一个 DeferredRegister，目标是 FluidType 注册表
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, create_cobblemon_potion.MODID); // 使用你的主类引用 MODID

    // ---------- 注册各种药水流体类型  ----------

    // 使用 DeferredHolder<FluidType, BaseFluidType>
    // 第一个参数是注册表类型 (FluidType)，第二个是你 Supplier 返回的具体类型 (BaseFluidType)
    public static final DeferredHolder<FluidType, BaseFluidType> MEDICINAL_BREW_FLUID_TYPE = register(
            "medicinal_brew_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.medicinal_brew_fluidtype"),
            0xFF_2DBAA0, // 淡蓝色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    // POTION
    public static final DeferredHolder<FluidType, BaseFluidType> POTION_FLUID_TYPE = register(
            "potion_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.potion_fluidtype"),
            0xFF_6e4f9c, // 紫色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical SUPER_POTION
    public static final DeferredHolder<FluidType, BaseFluidType> SUPER_POTION_FLUID_TYPE = register(
            "super_potion_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.super_potion_fluidtype"),
            0xFF_b95952, // 橘红色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical HYPER_POTION
    public static final DeferredHolder<FluidType, BaseFluidType>  HYPER_POTION_FLUID_TYPE = register(
            "hyper_potion_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.hyper_potion_fluidtype"),
            0xFF_dc6caa, // 粉红色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical MAX_POTION
    public static final DeferredHolder<FluidType, BaseFluidType>  MAX_POTION_FLUID_TYPE = register(
            "max_potion_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.max_potion_fluidtype"),
            0xFF_839cea, // 粉蓝色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical full_restore
    public static final DeferredHolder<FluidType, BaseFluidType>  FULL_RESTORE_FLUID_TYPE = register(
            "full_restore_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.full_restore_fluidtype"),
            0xFF_9bd57e, // 绿色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical ether
    public static final DeferredHolder<FluidType, BaseFluidType>  ETHER_FLUID_TYPE = register(
            "ether_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.ether_fluidtype"),
            0xFF_d5a6dd, // 紫色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical max ether
    public static final DeferredHolder<FluidType, BaseFluidType>  MAX_ETHER_FLUID_TYPE = register(
            "max_ether_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.max_ether_fluidtype"),
            0xFF_b9f197, // 绿色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical elixir
    public static final DeferredHolder<FluidType, BaseFluidType>  ELIXIR_FLUID_TYPE = register(
            "elixir_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.elixir_fluidtype"),
            0xFF_eeae95, // 棕色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    //medical max elixir
    public static final DeferredHolder<FluidType, BaseFluidType>  MAX_ELIXIR_FLUID_TYPE = register(
            "max_elixir_fluidtype",
            FluidType.Properties.create().density(1000).viscosity(1000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .descriptionId("fluid_type.create_cobblemon_potion.max_elixir_fluidtype"),
            0xFF_95eee1, // 绿色
            new Vector3f(248f / 255f, 92f / 255f, 92f / 255f)
    );
    // --- 私有 register 辅助方法  ---
    // 返回类型现在是 DeferredHolder<FluidType, BaseFluidType>
    private static @NotNull DeferredHolder<FluidType, BaseFluidType> register(String name, FluidType.Properties properties, int tintColor, Vector3f fogColor) {
        // register 方法现在返回 DeferredHolder
        return FLUID_TYPES.register(name, () -> new BaseFluidType(
                WATER_STILL_RL,
                WATER_FLOWING_RL,
                POTION_OVERLAY_RL,
                tintColor,
                fogColor,
                properties
        ));
    }
    // 需要一个方法来将这个 DeferredRegister 注册到事件总线
    // 这个方法通常在你的主模组类中调用
    public static void register(net.neoforged.bus.api.IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
    }
}
