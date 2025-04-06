package com.junto.create_cobblemon_potion.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class TestBlock extends Block {


    public TestBlock() {
        super(createProperties());
    }

    private static BlockBehaviour.Properties createProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE) // 地图颜色
                .strength(1.5f, 6.0f)   // 硬度 (破坏时间) 和 爆炸抗性
                .requiresCorrectToolForDrops() // 需要正确的工具才能掉落 (例如镐对石头)
                // 添加更多你需要的属性...
                // .sound(SoundType.STONE) // 声音类型 (通常从材质推断，但可以覆盖)
                // .lightLevel(state -> 0) // 光照等级 (默认为0)
                ;
    }
}
