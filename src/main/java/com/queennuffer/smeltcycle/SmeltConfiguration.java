package com.queennuffer.smeltcycle;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltConfiguration extends Configuration{
	private List<SmeltRecipe> _smeltingRecipes;
	private boolean _updatesSuspended;
	
	private static String[] _defaultRecipes = new String[] {
		"iron_sword,iron_ingot,1,0",
		"iron_axe,iron_ingot,2,0",
		"iron_hoe,iron_hoe,1,0",
		"iron_horse_armor,iron_ingot,4,0",
		"iron_pickaxe,iron_ingot,2,0",
		"iron_shovel,iron_ingot,1,0",
		"iron_boots,iron_ingot,3,0",
		"iron_chestplate,iron_ingot,6,0",
		"iron_helmet,iron_ingot,3,0",
		"iron_leggings,iron_ingot,5,0",
		"shears,iron_ingot,1,0",
		"bucket,iron_ingot,2,0",
		"cauldron,iron_ingot,2,0",
		"minecart,iron_ingot,4,0",
		"iron_door,iron_ingot,2,0",
		"diamond_sword,diamond,1,0",
		"diamond_axe,diamond,1,0",
		"diamond_hoe,diamond,1,0",
		"diamond_horse_armor,diamond,4,0",
		"diamond_pickaxe,diamond,1,0",
		"diamond_shovel,diamond,1,0",
		"diamond_boots,diamond,2,0",
		"diamond_chestplate,diamond,3,0",
		"diamond_helmet,diamond,2,0",
		"diamond_leggings,diamond,3,0",
		"golden_sword,gold_nugget,13,0",
		"golden_axe,gold_nugget,17,0",
		"golden_hoe,gold_nugget,13,0",
		"golden_horse_armor,gold_nugget,36,0",
		"golden_pickaxe,gold_nugget,17,0",
		"golden_shovel,gold_nugget,6,0",
		"golden_boots,gold_nugget,30,0",
		"golden_chestplate,gold_nugget,47,0",
		"golden_helmet,gold_nugget,47,0",
		"golden_leggings,gold_nugget,42,0"		
	};
	
	public SmeltConfiguration(File file){
		super(file, null);	
	}
	
	/* Shortcut method just to make the code easier to read */
	private String getItemName(Item item){
		return GameData.getItemRegistry().getNameForObject(item).toString();		
	}
	
	private boolean compare(ItemStack in, Item itemFor){
		if(in==null || itemFor == null) return false;
		return (getItemName(in.getItem()).equals(getItemName(itemFor)));
		
	}
	
	@SuppressWarnings("unchecked")
	public void removeRecipe(Item itemFor){							
		for(SmeltRecipe r : _smeltingRecipes){
			if(r.isFor(itemFor)){
				_smeltingRecipes.remove(r);
				break;
			}			
		}		
		updateFile();
	}
	
	public void addRecipe(SmeltRecipe recipe){
		removeRecipe(recipe.getItemIn());
		_smeltingRecipes.add(recipe);
		addSmeltingCycle(recipe.getItemIn(), recipe.getItemOut(), recipe.getResultSize(),  recipe.getResultExp());
		updateFile();
	}
	
    
    private void addSmeltingCycle(Item undamagedItem, Item returnItem, int returnQty, float xp){
    	ItemStack cycleItem = new ItemStack(undamagedItem);
    	cycleItem.setItemDamage(0);
    	GameRegistry.addSmelting(cycleItem, new ItemStack(returnItem, returnQty, 0), xp);    	
    }  
    
	public void addRecipe(Item itemIn, Item itemOut, int stackOut, float expOut){
		SmeltRecipe recipe = new SmeltRecipe(itemIn, itemOut, stackOut, expOut);
		addRecipe(recipe);
	}
	
	private void updateFile(){
		if(_updatesSuspended) return;
		Property prop = this.get("Recipes", "Smelting", _defaultRecipes);
		String[] smeltingRecipes = new String[_smeltingRecipes.size()];

		int i =0;
		for(SmeltRecipe r : _smeltingRecipes){
			smeltingRecipes[i] = r.toString();
			i++;
		}		
		prop.setValues(smeltingRecipes);	
		save();
	}
	
	public void load(){
		super.load();
		_updatesSuspended = true;
		_smeltingRecipes = new ArrayList<SmeltRecipe>();				
		String[] smeltingRecipes;
		smeltingRecipes = this.get("Recipes", "Smelting", _defaultRecipes).getStringList();
		for(int i=0; i < smeltingRecipes.length; i++){
			addRecipe(new SmeltRecipe(smeltingRecipes[i]));
		}					
		_updatesSuspended = false;
		updateFile();
	}
		
	public Iterator<SmeltRecipe> getRecipes(){
		return _smeltingRecipes.iterator();
	}
}
