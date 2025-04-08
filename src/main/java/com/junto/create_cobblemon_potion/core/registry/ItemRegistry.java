package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import com.junto.create_cobblemon_potion.common.item.block.Item_TestBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(create_cobblemon_potion.MODID);

//    public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block",
//            () -> new Item_TestBlock(
//                    BlockRegistry.TEST_BLOCK.get(), // Get the registered block instance
//                    new Item.Properties() // Provide standard item properties
//                    // Note: Adjust properties if needed (e.g., .stacksTo(64))
//            )
//            );

    // 注册药水桶
    public static final DeferredHolder<Item, BucketItem> MEDICINAL_BREW_BUCKET = ITEMS.register(
            "medicinal_brew_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.MEDICINAL_BREW_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical potion
    public static final DeferredHolder<Item, BucketItem> POTION_BUCKET = ITEMS.register(
            "potion_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.POTION_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );

    // medical super potion
    public static final DeferredHolder<Item, BucketItem> SUPER_POTION_BUCKET = ITEMS.register(
            "super_potion_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.SUPER_POTION_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );

    // medical hyper potion
    public static final DeferredHolder<Item, BucketItem> HYPER_POTION_BUCKET = ITEMS.register(
            "hyper_potion_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.HYPER_POTION_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical max potion
    public static final DeferredHolder<Item, BucketItem> MAX_POTION_BUCKET = ITEMS.register(
            "max_potion_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.MAX_POTION_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical full restore
    public static final DeferredHolder<Item, BucketItem> FULL_RESTORE_BUCKET = ITEMS.register(
            "full_restore_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.FULL_RESTORE_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical ether
    public static final DeferredHolder<Item, BucketItem> ETHER_BUCKET = ITEMS.register(
            "ether_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.ETHER_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical max ether
    public static final DeferredHolder<Item, BucketItem> MAX_ETHER_BUCKET = ITEMS.register(
            "max_ether_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.MAX_ETHER_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical elixir
    public static final DeferredHolder<Item, BucketItem> ELIXIR_BUCKET = ITEMS.register(
            "elixir_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.ELIXIR_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical max elixir
    public static final DeferredHolder<Item, BucketItem> MAX_ELIXIR_BUCKET = ITEMS.register(
            "max_elixir_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.MAX_ELIXIR_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical antidote
    public static final DeferredHolder<Item, BucketItem> ANTIDOTE_BUCKET = ITEMS.register(
            "antidote_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.ANTIDOTE_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical awakening
    public static final DeferredHolder<Item, BucketItem> AWAKENING_BUCKET = ITEMS.register(
            "awakening_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.AWAKENING_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical burn heal
    public static final DeferredHolder<Item, BucketItem> BURN_HEAL_BUCKET = ITEMS.register(
            "burn_heal_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.BURN_HEAL_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical ice heal
    public static final DeferredHolder<Item, BucketItem> ICE_HEAL_BUCKET = ITEMS.register(
            "ice_heal_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.ICE_HEAL_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical paralyze heal
    public static final DeferredHolder<Item, BucketItem> PARALYZE_HEAL_BUCKET = ITEMS.register(
            "paralyze_heal_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.PARALYZE_HEAL_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    // medical full heal
    public static final DeferredHolder<Item, BucketItem> FULL_HEAL_BUCKET = ITEMS.register(
            "full_heal_bucket",
            () -> new BucketItem(
                    // **直接传递 DeferredHolder<Fluid, FlowingFluid> 给需要 Supplier<Fluid> 的构造函数**
                    // 因为 DeferredHolder 实现了 Supplier<Fluid> 接口
                    FluidRegistry.FULL_HEAL_SOURCE.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
