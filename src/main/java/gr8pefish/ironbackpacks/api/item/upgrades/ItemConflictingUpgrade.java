package gr8pefish.ironbackpacks.api.item.upgrades;

import gr8pefish.ironbackpacks.api.IronBackpacksAPI;
import gr8pefish.ironbackpacks.api.item.upgrades.interfaces.IConflictingUpgrade;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.Arrays;
import java.util.List;

public class ItemConflictingUpgrade implements IConflictingUpgrade {

    private String name;
    private int upgradeCost;
    private int tier;
    private String[] description;
    private List<ItemConflictingUpgrade> conflictingUpgrades;
    private IRecipe itemRecipe;

    public ItemConflictingUpgrade(String name, int upgradeCost, int tier, String[] description, List<ItemConflictingUpgrade> conflictingUpgrades){
        this.name = name;
        this.upgradeCost = upgradeCost;
        this.description = description;
        this.tier = tier;
        this.conflictingUpgrades = conflictingUpgrades;
    }

    public Item getItem(){
        return IronBackpacksAPI.getItem(IronBackpacksAPI.ITEM_CRAFTING_BASE);
    }

    @Override
    public String getName(ItemStack upgrade) {
        return name;
    }

    @Override
    public int getUpgradeCost(ItemStack upgrade) {
        return upgradeCost;
    }

    @Override
    public List<String> getTooltip(ItemStack upgrade) {
        return Arrays.asList(description);
    }

    @Override
    public List<ItemConflictingUpgrade> getConflictingUpgrades(ItemStack upgrade) {
        return conflictingUpgrades;
    }

    @Override
    public int getTier(ItemStack upgrade) {
        return tier;
    }

    @Override
    public IRecipe getItemRecipe(ItemStack upgrade) {
        return itemRecipe;
    }

    @Override
    public void setItemRecipe(IRecipe recipe) {
        itemRecipe = recipe;
    }
}
