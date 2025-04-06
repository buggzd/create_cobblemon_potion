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

    public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block",
            () -> new Item_TestBlock(
                    BlockRegistry.TEST_BLOCK.get(), // Get the registered block instance
                    new Item.Properties() // Provide standard item properties
                    // Note: Adjust properties if needed (e.g., .stacksTo(64))
            )
            );

    // 注册药水桶
    public static final DeferredHolder<Item, BucketItem> POTION_BUCKET = ITEMS.register(
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
