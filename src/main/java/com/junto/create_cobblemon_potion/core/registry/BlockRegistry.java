package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import com.junto.create_cobblemon_potion.common.block.TestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry extends Blocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(create_cobblemon_potion.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.register(
            "test_block",
            ()-> new TestBlock()
    );

    // 药水流体方块
    public static final DeferredHolder<Block, LiquidBlock> POTION_BLOCK = BLOCKS.register(
            "medicinal_brew_block", // 方块的注册名
            () -> new LiquidBlock(
                    FluidRegistry.MEDICINAL_BREW_SOURCE.get(), // **重要：** 引用 FluidRegistry 中的源流体 Supplier
                    // 复制水的方块属性 (材质、无碰撞、亮度、破坏时间等)
                    // 如果 ofFullCopy 有问题，可以尝试 Properties.of().noCollission().strength(100f).lightLevel(...) 等手动设置
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable() // 通常流体方块不掉落物品
            )
    );

//    //Crops:
//    public static final RegistryObject<Block> COFFEE = BLOCKS.register("coffee_crop",
//            () -> new CoffeeBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
//
//    public static final RegistryObject<Block> CASSAVA = BLOCKS.register("cassava_crop",
//            () -> new CassavaBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
