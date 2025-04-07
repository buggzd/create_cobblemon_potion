package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
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
                    .icon(() -> ItemRegistry.MEDICINAL_BREW_BUCKET.get().getDefaultInstance()) // *** 修改图标为药水桶 ***
                    .displayItems((itemDisplayParameters, output) -> {
                        // 将模组物品添加到此标签页
                        output.accept(ItemRegistry.TEST_BLOCK_ITEM.get()); // 保留测试方块物品

                        // --- 在这里添加药水桶 ---
                        // healthy
                        output.accept(ItemRegistry.MEDICINAL_BREW_BUCKET.get());
                        output.accept(ItemRegistry.POTION_BUCKET.get());
                        output.accept(ItemRegistry.SUPER_POTION_BUCKET.get());
                        output.accept(ItemRegistry.HYPER_POTION_BUCKET.get());
                        output.accept(ItemRegistry.MAX_POTION_BUCKET.get());
                        output.accept(ItemRegistry.FULL_RESTORE_BUCKET.get());
                        // pp
                        output.accept(ItemRegistry.ETHER_BUCKET.get());
                        output.accept(ItemRegistry.MAX_ETHER_BUCKET.get());
                        output.accept(ItemRegistry.ELIXIR_BUCKET.get());
                        output.accept(ItemRegistry.MAX_ELIXIR_BUCKET.get());
                        // debuff
                        output.accept(ItemRegistry.ANTIDOTE_BUCKET.get());
                        output.accept(ItemRegistry.AWAKENING_BUCKET.get());


                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
