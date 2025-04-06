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
                    .icon(() -> ItemRegistry.POTION_BUCKET.get().getDefaultInstance()) // *** 修改图标为药水桶 ***
                    .displayItems((itemDisplayParameters, output) -> {
                        // 将模组物品添加到此标签页
                        output.accept(ItemRegistry.TEST_BLOCK_ITEM.get()); // 保留测试方块物品

                        // --- 在这里添加药水桶 ---
                        output.accept(ItemRegistry.POTION_BUCKET.get());

                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
