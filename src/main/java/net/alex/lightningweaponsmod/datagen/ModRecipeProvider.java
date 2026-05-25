package net.alex.lightningweaponsmod.datagen;

import net.alex.lightningweaponsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_STICK, 1)
                .pattern("T")
                .pattern("S")
                .input('T', Items.TRIDENT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.TRIDENT), conditionsFromItem(Items.TRIDENT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_STICK)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_SWORD, 1)
                .pattern("D")
                .pattern("D")
                .pattern("S")
                .input('D', Items.DIAMOND)
                .input('S', ModItems.LIGHTNING_STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.LIGHTNING_STICK), conditionsFromItem(ModItems.LIGHTNING_STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_BOW, 1)
                .pattern(" LS")
                .pattern("L S")
                .pattern(" LS")
                .input('L', ModItems.LIGHTNING_STICK)
                .input('S', Items.STRING)
                .criterion(hasItem(ModItems.LIGHTNING_STICK), conditionsFromItem(ModItems.LIGHTNING_STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_BOW)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', ModItems.LIGHTNING_STICK)
                .criterion(hasItem(ModItems.LIGHTNING_STICK), conditionsFromItem(ModItems.LIGHTNING_STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.LIGHTNING_STICK)
                .criterion(hasItem(ModItems.LIGHTNING_STICK), conditionsFromItem(ModItems.LIGHTNING_STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.LIGHTNING_STICK)
                .criterion(hasItem(ModItems.LIGHTNING_STICK), conditionsFromItem(ModItems.LIGHTNING_STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LIGHTNING_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.LIGHTNING_STICK)
                .criterion(hasItem(ModItems.LIGHTNING_STICK), conditionsFromItem(ModItems.LIGHTNING_STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_BOOTS)));
    }
}
