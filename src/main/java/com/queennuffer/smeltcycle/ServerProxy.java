package com.queennuffer.smeltcycle;

import java.io.File;
import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy {
	public SmeltConfiguration config;

	public void registerRenderers(){
		
	}

	public void doPreInit(FMLPreInitializationEvent event){
		File file = event.getSuggestedConfigurationFile();
		config = new SmeltConfiguration(file);		
	}
	
	public void removeRecipe(Item itemIn){
		
	}
	
	public void addRecipe(Item itemIn, Item itemOut, int stackOut, float expOut){
		config.addRecipe(itemIn, itemOut, stackOut, expOut);
	}	
	
    public void doInit(FMLInitializationEvent event){
/*    	Iterator<SmeltRecipe> recipes = config.getRecipes();
    	while(recipes.hasNext()){
    		SmeltRecipe r = recipes.next();
    		addSmeltingCycle(r.getItemIn(), r.getItemOut(), r.getResultSize(), r.getResultExp());
    		System.out.println("Added recipe for " + r.getItemIn().getUnlocalizedName());    		
    	}*/
    }
  	
}
