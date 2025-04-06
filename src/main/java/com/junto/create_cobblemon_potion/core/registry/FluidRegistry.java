package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FluidRegistry {
    // 创建一个 Fluid 的 DeferredRegister
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, create_cobblemon_potion.MODID);

    // ---------- 注册药水流体 ----------

    // 1. 注册源流体 (名字可以自定义，例如 potion_source_fluid)
    //    这里使用了 BaseFlowingFluid.Source
    //    它需要一个 Fluid.Properties Supplier，我们稍后定义
    public static final DeferredHolder<Fluid, FlowingFluid> MEDICINAL_BREW_SOURCE = FLUIDS.register(
            "medicinal_brew_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.MEDICINAL_BREW_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    // 2. 注册流动流体 (名字建议和源对应，加 _flowing 后缀)
    //    这里使用了 BaseFlowingFluid.Flowing
    public static final DeferredHolder<Fluid, FlowingFluid> POTION_FLOWING = FLUIDS.register(
            "medicinal_brew_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.MEDICINAL_BREW_FLUID_PROPERTIES) // 引用下面的 Properties
    );


    // 3. 定义流体属性 (Properties)
    //    **关键步骤**：关联 FluidType, Source, Flowing, Bucket, Block
    private static final BaseFlowingFluid.Properties MEDICINAL_BREW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.POTION_FLUID_TYPE, // 关联 FluidType
            MEDICINAL_BREW_SOURCE,                       // 关联源流体
            POTION_FLOWING                       // 关联流动流体
    )
            // --- 现在可以取消注释并正确关联了 ---
            .bucket(ItemRegistry.POTION_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.POTION_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // --- 可选：调整流动属性 ---
    // .slopeFindDistance(2) // 寻找斜坡的距离 (影响流动方向)
    // .levelDecreasePerBlock(2) // 每格降低的水位 (影响流动距离)
    // .tickRate(5) // 流动 tick 速率 (默认是 5)


    // --- 为其他药水重复以上步骤 ---
    // 如果你有 Super Potion Fluid Type 等，也需要在这里定义对应的 Source, Flowing 和 Properties


    // 注册到事件总线的方法
    public static void register(IEventBus modEventBus) {
        FLUIDS.register(modEventBus);
    }

    private FluidRegistry() {}
}
