package com.junto.create_cobblemon_potion.core.registry;

import com.create_cobblemon_potion;
import com.junto.create_cobblemon_potion.common.block.TestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry extends Blocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(create_cobblemon_potion.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.register(
            "test_block",
            ()-> new TestBlock( BlockBehaviour.Properties.of().mapColor(MapColor.STONE))
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
