package com.besson.tutorial.tag;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> ORE_TAGS = creat("ore_tags");

    private static TagKey<Block> creat(String pName) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, pName));
    }

    private static TagKey<Block> creatForgeTag(String pName) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("forge", pName));
    }
}
