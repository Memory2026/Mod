package com.besson.tutorial.datagen;

import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {

    public ModBlockLootTablesProvider() {
        // 修改点 1: 显式指定使用的特性标志
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ICE_ETHER_BLOCK.get());
        dropSelf(ModBlocks.RAW_ICE_ETHER_BLOCK.get());

        // 使用 lambda 传入的 block 变量，而不是再次 .get()
        this.add(ModBlocks.ICE_ETHER_ORE.get(),
                block -> createCopperOreLikeDrops(block, ModItems.RAW_ICE_ETHER.get()));
    }


    // 辅助方法：类似于铜矿的掉落（受时运影响，掉落多个）
    protected LootTable.Builder createCopperOreLikeDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // 修改点 3: 这里的写法是正确的，但请确保 ModBlocks.BLOCKS 里的所有 Block 都在 generate() 里写了掉落
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}
