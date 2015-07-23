package com.queennuffer.smeltcycle;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy {
	public SmeltingConfig config;
	
	public void registerRenderers(){
		
	}

	public void doPreInit(FMLPreInitializationEvent event){
    	/*config = new SmeltingConfig(event.getSuggestedConfigurationFile());
    	config.load();
    	String itemList[] = new String;
    	Property items = config.get(Configuration.CATEGORY_GENERAL, "smelt_items", itemList);
    	itemList = items.getStringList();
    	for(int i=0; i < itemList.length; i++){
    		
    	}
    	itemList[itemList.length] = "Test";
    	items.set(itemList);
    	config.save();*/		
	}
}
