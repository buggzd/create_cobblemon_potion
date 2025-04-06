package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import com.junto.create_cobblemon_potion.common.item.Item_TestBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
