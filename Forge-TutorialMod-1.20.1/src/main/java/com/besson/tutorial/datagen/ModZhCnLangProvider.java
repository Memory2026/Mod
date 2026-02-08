package com.besson.tutorial.datagen;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {

    public ModZhCnLangProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ICE_ETHER.get(), "冰以太");
        add(ModItems.RAW_ICE_ETHER.get(), "原始冰以太");
        add(ModItems.CARDBOARD.get(), "硬纸板");

        add(ModItems.CORN.get(), "玉米");
        add(ModItems.STRAWBERRY.get(), "草莓");
        add(ModItems.CHEESE.get(), "奶酪");

        add(ModItems.ANTHRACITE.get(), "无烟煤");
        add(ModItems.PROSPECTOR.get(), "勘探者");

        add(ModBlocks.ICE_ETHER_BLOCK.get(), "冰以太块");
        add(ModBlocks.RAW_ICE_ETHER_BLOCK.get(), "原始冰以太块");
        add(ModBlocks.ICE_ETHER_ORE.get(), "冰以太矿石");

        add("itemGroup.tutorial_tab", "教程模组物品");
        add("itemGroup.material", "材料");
    }
}
