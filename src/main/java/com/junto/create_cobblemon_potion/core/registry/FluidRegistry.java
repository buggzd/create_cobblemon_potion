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
    // medical 药酿
    // 1. 注册源流体 (名字可以自定义，例如 potion_source_fluid)
    //    这里使用了 BaseFlowingFluid.Source
    //    它需要一个 Fluid.Properties Supplier，我们稍后定义
    public static final DeferredHolder<Fluid, FlowingFluid> MEDICINAL_BREW_SOURCE = FLUIDS.register(
            "medicinal_brew_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.MEDICINAL_BREW_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    // 2. 注册流动流体 (名字建议和源对应，加 _flowing 后缀)
    //    这里使用了 BaseFlowingFluid.Flowing
    public static final DeferredHolder<Fluid, FlowingFluid> MEDICINAL_BREW_FLOWING = FLUIDS.register(
            "medicinal_brew_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.MEDICINAL_BREW_FLUID_PROPERTIES) // 引用下面的 Properties
    );


    // 3. 定义流体属性 (Properties)
    //    **关键步骤**：关联 FluidType, Source, Flowing, Bucket, Block
    private static final BaseFlowingFluid.Properties MEDICINAL_BREW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.MEDICINAL_BREW_FLUID_TYPE, // 关联 FluidType
            MEDICINAL_BREW_SOURCE,                       // 关联源流体
            MEDICINAL_BREW_FLOWING                       // 关联流动流体
    )
            // --- 现在可以取消注释并正确关联了 ---
            .bucket(ItemRegistry.MEDICINAL_BREW_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.MEDICINAL_BREW_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // --- 可选：调整流动属性 ---
    // .slopeFindDistance(2) // 寻找斜坡的距离 (影响流动方向)
    // .levelDecreasePerBlock(2) // 每格降低的水位 (影响流动距离)
    // .tickRate(5) // 流动 tick 速率 (默认是 5)


    // --- 为其他药水重复以上步骤 ---
    // 如果你有 Super Potion Fluid Type 等，也需要在这里定义对应的 Source, Flowing 和 Properties
    // medical  potion 伤药
    public static final DeferredHolder<Fluid, FlowingFluid> POTION_SOURCE = FLUIDS.register(
            "potion_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> POTION_FLOWING = FLUIDS.register(
            "potion_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties POTION_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.POTION_FLUID_TYPE, // 关联 FluidType
            POTION_SOURCE,                       // 关联源流体
            POTION_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.POTION_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.POTION_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**

    //medical super potion 好伤药
    public static final DeferredHolder<Fluid, FlowingFluid> SUPER_POTION_SOURCE = FLUIDS.register(
            "super_potion_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.SUPER_POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> SUPER_POTION_FLOWING = FLUIDS.register(
            "super_potion_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.SUPER_POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties SUPER_POTION_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.SUPER_POTION_FLUID_TYPE, // 关联 FluidType
            SUPER_POTION_SOURCE,                       // 关联源流体
            SUPER_POTION_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.SUPER_POTION_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.SUPER_POTION_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**

    //medical hyper potion 厉害伤药
    public static final DeferredHolder<Fluid, FlowingFluid> HYPER_POTION_SOURCE = FLUIDS.register(
            "hyper_potion_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.HYPER_POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> HYPER_POTION_FLOWING = FLUIDS.register(
            "hyper_potion_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.HYPER_POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties HYPER_POTION_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.HYPER_POTION_FLUID_TYPE, // 关联 FluidType
            HYPER_POTION_SOURCE,                       // 关联源流体
            HYPER_POTION_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.HYPER_POTION_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.HYPER_POTION_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    //medical max potion 全满药
    public static final DeferredHolder<Fluid, FlowingFluid> MAX_POTION_SOURCE = FLUIDS.register(
            "max_potion_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.MAX_POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> MAX_POTION_FLOWING = FLUIDS.register(
            "max_potion_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.MAX_POTION_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties MAX_POTION_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.MAX_POTION_FLUID_TYPE, // 关联 FluidType
            MAX_POTION_SOURCE,                       // 关联源流体
            MAX_POTION_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.MAX_POTION_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.MAX_POTION_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**

    //medical full restore
    public static final DeferredHolder<Fluid, FlowingFluid> FULL_RESTORE_SOURCE = FLUIDS.register(
            "full_restore_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.FULL_RESTORE_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> FULL_RESTORE_FLOWING = FLUIDS.register(
            "full_restore_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.FULL_RESTORE_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties FULL_RESTORE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.FULL_RESTORE_FLUID_TYPE, // 关联 FluidType
            FULL_RESTORE_SOURCE,                       // 关联源流体
            FULL_RESTORE_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.FULL_RESTORE_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.FULL_RESTORE_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // medical ether
    public static final DeferredHolder<Fluid, FlowingFluid> ETHER_SOURCE = FLUIDS.register(
            "ether_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.ETHER_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> ETHER_FLOWING = FLUIDS.register(
            "ether_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.ETHER_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties ETHER_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.ETHER_FLUID_TYPE, // 关联 FluidType
            ETHER_SOURCE,                       // 关联源流体
            ETHER_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.ETHER_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.ETHER_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // medical max ether
    public static final DeferredHolder<Fluid, FlowingFluid> MAX_ETHER_SOURCE = FLUIDS.register(
            "max_ether_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.MAX_ETHER_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> MAX_ETHER_FLOWING = FLUIDS.register(
            "max_ether_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.MAX_ETHER_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties MAX_ETHER_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.MAX_ETHER_FLUID_TYPE, // 关联 FluidType
            MAX_ETHER_SOURCE,                       // 关联源流体
            MAX_ETHER_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.MAX_ETHER_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.MAX_ETHER_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**

    // medical elixir
    public static final DeferredHolder<Fluid, FlowingFluid> ELIXIR_SOURCE = FLUIDS.register(
            "elixir_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.ELIXIR_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> ELIXIR_FLOWING = FLUIDS.register(
            "elixir_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.ELIXIR_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties ELIXIR_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.ELIXIR_FLUID_TYPE, // 关联 FluidType
            ELIXIR_SOURCE,                       // 关联源流体
            ELIXIR_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.ELIXIR_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.ELIXIR_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // medical max elixir
    public static final DeferredHolder<Fluid, FlowingFluid> MAX_ELIXIR_SOURCE = FLUIDS.register(
            "max_elixir_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.MAX_ELIXIR_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> MAX_ELIXIR_FLOWING = FLUIDS.register(
            "max_elixir_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.MAX_ELIXIR_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties MAX_ELIXIR_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.MAX_ELIXIR_FLUID_TYPE, // 关联 FluidType
            MAX_ELIXIR_SOURCE,                       // 关联源流体
            MAX_ELIXIR_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.MAX_ELIXIR_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.MAX_ELIXIR_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // medical antidote
    public static final DeferredHolder<Fluid, FlowingFluid> ANTIDOTE_SOURCE = FLUIDS.register(
            "antidote_source", // 注册名 (源)
            () -> new BaseFlowingFluid.Source(FluidRegistry.ANTIDOTE_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    public static final DeferredHolder<Fluid, FlowingFluid> ANTIDOTE_FLOWING = FLUIDS.register(
            "antidote_flowing", // 注册名 (流动)
            () -> new BaseFlowingFluid.Flowing(FluidRegistry.ANTIDOTE_FLUID_PROPERTIES) // 引用下面的 Properties
    );

    private static final BaseFlowingFluid.Properties ANTIDOTE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegistry.ANTIDOTE_FLUID_TYPE, // 关联 FluidType
            ANTIDOTE_SOURCE,                       // 关联源流体
            ANTIDOTE_FLOWING                       // 关联流动流体
    )
            .bucket(ItemRegistry.ANTIDOTE_BUCKET) // **现在引用 ItemRegistry 中的 DeferredHolder**
            .block(BlockRegistry.ANTIDOTE_BLOCK); // **现在引用 BlockRegistry 中的 DeferredHolder**
    // 注册到事件总线的方法
    public static void register(IEventBus modEventBus) {
        FLUIDS.register(modEventBus);
    }

    private FluidRegistry() {}
}
