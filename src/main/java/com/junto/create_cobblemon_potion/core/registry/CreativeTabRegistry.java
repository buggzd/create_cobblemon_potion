package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,create_cobblemon_potion.MODID);

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> CREATECOBBLEMONPOTION =
            CREATIVE_MODE_TABS.register("create_cobblemon_potion",()->CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.create_cobblemon_potion"))
                    .withTabsBefore(CreativeModeTabs.COMBAT) // Position relative to other tabs
                    .icon(() -> ItemRegistry.TEST_BLOCK_ITEM.get().getDefaultInstance()) // Icon using an item from ItemRegistry
                    .displayItems((itemDisplayParameters, output) -> {
                    // add every mod Items into creative tab
                        output.accept(ItemRegistry.TEST_BLOCK_ITEM.get());

                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
