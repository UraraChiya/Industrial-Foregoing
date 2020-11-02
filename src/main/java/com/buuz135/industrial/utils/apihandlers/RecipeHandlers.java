/*
 * This file is part of Industrial Foregoing.
 *
 * Copyright 2019, Buuz135
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.buuz135.industrial.utils.apihandlers;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.FluidDictionaryEntry;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import com.buuz135.industrial.api.recipe.SludgeEntry;
import com.buuz135.industrial.utils.apihandlers.crafttweaker.CTAction;
import com.google.common.collect.LinkedListMultimap;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;

public class RecipeHandlers {

    public static final LinkedListMultimap<CTAction, BioReactorEntry> BIOREACTOR_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<CTAction, SludgeEntry> SLUDGE_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<CTAction, ProteinReactorEntry> PROTEIN_REACTOR_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<CTAction, FluidDictionaryEntry> FLUID_DICTIONARY_ENTRIES = LinkedListMultimap.create();

    public static void loadBioReactorEntries() {
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.WHEAT_SEEDS)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.PUMPKIN_SEEDS)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.MELON_SEEDS)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.BEETROOT_SEEDS)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.CARROT)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.POTATO)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Items.NETHER_WART)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Blocks.BROWN_MUSHROOM)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Blocks.RED_MUSHROOM)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Blocks.CHORUS_FLOWER)));
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(Blocks.SUGAR_CANE)));
        //TagUtil.getAllEntries(Tags.Items.DYES).forEach(item -> IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(new ItemStack(item)))); TODO
        //TagUtil.getAllEntries(ItemTags.SAPLINGS).stream().filter(item -> !item.getRegistryName().getNamespace().equals("forestry")).map(ItemStack::new).forEach(stack -> IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(stack)));
    }

    public static void executeCraftweakerActions() {
        BIOREACTOR_ENTRIES.forEach((ctAction, entry) -> {
            if (ctAction == CTAction.ADD) IndustrialForegoingHelper.addBioReactorEntry(entry);
            else IndustrialForegoingHelper.removeBioReactorEntry(entry.getStack());
        });
        SLUDGE_ENTRIES.forEach((ctAction, entry) -> {
            if (ctAction == CTAction.ADD) IndustrialForegoingHelper.addSludgeRefinerEntry(entry);
            else IndustrialForegoingHelper.removeSludgeRefinerEntry(entry.getStack());
        });
        PROTEIN_REACTOR_ENTRIES.forEach((ctAction, entry) -> {
            if (ctAction == CTAction.ADD) IndustrialForegoingHelper.addProteinReactorEntry(entry);
            else IndustrialForegoingHelper.removeProteinReactorEntry(entry.getStack());
        });
        FLUID_DICTIONARY_ENTRIES.forEach((ctAction, entry) -> {
            if (ctAction == CTAction.ADD) IndustrialForegoingHelper.addFluidDictionaryEntry(entry);
            else IndustrialForegoingHelper.removeFluidDictionaryEntry(entry);
        });
    }

    public static void loadSludgeRefinerEntries() {
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Items.CLAY_BALL), 4));
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.CLAY), 1));
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.DIRT), 4));
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.GRAVEL), 4));
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.MYCELIUM), 1));
        //IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.DIRT, 1, 2), 1));
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.SAND), 4));
        //IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.SAND, 1, 1), 4));
        IndustrialForegoingHelper.addSludgeRefinerEntry(new SludgeEntry(new ItemStack(Blocks.SOUL_SAND), 4));
    }

    public static void loadProteinReactorEntries() {
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.PORKCHOP)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.BEEF)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.CHICKEN)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.RABBIT)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.MUTTON)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.RABBIT_FOOT)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.ROTTEN_FLESH)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.EGG)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.SPIDER_EYE)));
        IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(new ItemStack(Items.PORKCHOP)));
        NonNullList<ItemStack> stacks = NonNullList.create();
        stacks.add(new ItemStack(Items.TROPICAL_FISH));
        stacks.add(new ItemStack(Items.PUFFERFISH));
        stacks.add(new ItemStack(Items.SALMON));
        stacks.add(new ItemStack(Items.COD));
        stacks.add(new ItemStack(Items.SKELETON_SKULL));
        stacks.add(new ItemStack(Items.CREEPER_HEAD));
        stacks.add(new ItemStack(Items.DRAGON_HEAD));
        stacks.add(new ItemStack(Items.PLAYER_HEAD));
        stacks.add(new ItemStack(Items.ZOMBIE_HEAD));
        stacks.forEach(stack -> IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(stack)));
    }

    public static void loadFluidDictionaryEntries() {
        addFluidEntryDoubleDirectional("essence", "xpjuice", 1);
        addFluidEntryDoubleDirectional("essence", "experience", 1);
        addFluidEntryDoubleDirectional("xpjuice", "experience", 1);
    }

    public static void loadWoodToLatexEntries() {
//        tryToAddWoodToLatex("ic2:rubber_wood", new FluidStack(FluidsRegistry.LATEX, 4));
//        tryToAddWoodToLatex("techreborn:rubber_log", new FluidStack(FluidsRegistry.LATEX, 4));
//        IndustrialForegoingHelper.addWoodToLatex(new ExtractorEntry(new ItemStack(Blocks.DARK_OAK_LOG), new FluidStack(FluidsRegistry.LATEX, 3)));
//        IndustrialForegoingHelper.addWoodToLatex(new ExtractorEntry(new ItemStack(Blocks.ACACIA_LOG), new FluidStack(FluidsRegistry.LATEX, 2)));
//        TagUtil.getAllEntries(ItemTags.LOGS).forEach(stack -> IndustrialForegoingHelper.addWoodToLatex(new ExtractorEntry(new ItemStack(stack), new FluidStack(FluidsRegistry.LATEX, 1))));
    }

    public static void loadOreEntries() {
        /*
        for (String s : OreDictionary.getOreNames()) {
            if (s.startsWith("ore") && !OreDictionary.getOres(s).isEmpty() && OreDictionary.doesOreNameExist("dust" + s.replace("ore", "")) && !OreDictionary.getOres("dust" + s.replace("ore", "")).isEmpty()) {
                IndustrialForegoingHelper.addOreFluidEntryRaw(new OreFluidEntryRaw(s, new FluidStack(FluidsRegistry.MEAT, 200), FluidsRegistry.ORE_FLUID_RAW.getWithOre(s, 150)));
                IndustrialForegoingHelper.addOreFluidEntryFermenter(new OreFluidEntryFermenter(FluidsRegistry.ORE_FLUID_RAW.getWithOre(s, 1), FluidsRegistry.ORE_FLUID_FERMENTED.getWithOre(s, 2)));
                IndustrialForegoingHelper.addOreFluidEntrySieve(new OreFluidEntrySieve(FluidsRegistry.ORE_FLUID_FERMENTED.getWithOre(s, 100), OreDictionary.getOres("dust" + s.replace("ore", "")).get(0).copy(), new ItemStack(Blocks.SAND)));
            }
        }*/
//        IndustrialForegoingHelper.addOreFluidEntrySieve(new OreFluidEntrySieve(new FluidStack(FluidsRegistry.PINK_SLIME, 2000), new ItemStack(ItemRegistry.pinkSlimeIngot), new ItemStack(Items.IRON_INGOT)));
    }

    public static void addFluidEntryDoubleDirectional(String fluidInput, String fluidOutput, double ratio) {
        IndustrialForegoingHelper.addFluidDictionaryEntry(new FluidDictionaryEntry(fluidInput, fluidOutput, ratio));
        IndustrialForegoingHelper.addFluidDictionaryEntry(new FluidDictionaryEntry(fluidOutput, fluidInput, 1 / ratio));
    }

    public static void getSubItems(NonNullList<ItemStack> list, ItemStack stack) {
        if (stack.getItem().getGroup() != null)
            stack.getItem().fillItemGroup(stack.getItem().getGroup(), list);
    }

}


