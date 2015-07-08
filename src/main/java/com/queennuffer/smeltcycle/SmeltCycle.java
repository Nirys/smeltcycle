package com.queennuffer.smeltcycle;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SmeltCycle.MODID, name="SmeltCycle", version = SmeltCycle.VERSION, acceptableRemoteVersions = "*")
public class SmeltCycle
{
	@Instance("SmeltCycle")
	@SidedProxy(clientSide="com.queennuffer.smeltcycle.SmeltCycle", serverSide="com.queennuffer.smeltcycle.SmeltCycle")
	public static SmeltCycle instance;

    public static final String MODID = "SmeltCycle";
    public static final String VERSION = "1.1";
    
    public SmeltCycle(){
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing SmeltCycle");
        this.addIronItems();
        this.addGoldenItems();
        this.addDiamondItems();        
    }
        
    private void addSmeltingCycle(Item undamagedItem, Item returnItem, int returnQty, float xp){
    	ItemStack cycleItem = new ItemStack(undamagedItem);
    	cycleItem.setItemDamage(0);
    	GameRegistry.addSmelting(cycleItem, new ItemStack(returnItem, returnQty, 0), xp);    	
    }
    
    private void addDiamondItems(){
    	this.addSmeltingCycle(Items.diamond_sword, Items.diamond, 1, 0);
    	this.addSmeltingCycle(Items.diamond_axe, Items.diamond, 1, 0);
    	this.addSmeltingCycle(Items.diamond_hoe, Items.diamond, 1, 0);
    	this.addSmeltingCycle(Items.diamond_horse_armor, Items.diamond, 4,0);
    	this.addSmeltingCycle(Items.diamond_pickaxe, Items.diamond, 1, 0);
    	this.addSmeltingCycle(Items.diamond_shovel, Items.diamond, 1, 0);
    	this.addSmeltingCycle(Items.diamond_boots, Items.diamond, 2,0 );
    	this.addSmeltingCycle(Items.diamond_chestplate, Items.diamond, 3, 0 );
    	this.addSmeltingCycle(Items.diamond_helmet, Items.diamond, 2, 0);
     	this.addSmeltingCycle(Items.diamond_leggings, Items.diamond, 3, 0);    	    
    }

    
    private void addIronItems(){
    	this.addSmeltingCycle(Items.iron_sword, Items.iron_ingot, 1, 0);
    	this.addSmeltingCycle(Items.iron_axe, Items.iron_ingot, 2, 0);
    	this.addSmeltingCycle(Items.iron_hoe, Items.iron_hoe, 1, 0);
    	this.addSmeltingCycle(Items.iron_horse_armor, Items.iron_ingot, 4,0);
    	this.addSmeltingCycle(Items.iron_pickaxe, Items.iron_pickaxe, 2, 0);
    	this.addSmeltingCycle(Items.iron_shovel, Items.iron_ingot, 1, 0);
    	this.addSmeltingCycle(Items.iron_boots, Items.iron_ingot, 3,0 );
    	this.addSmeltingCycle(Items.iron_chestplate, Items.iron_ingot, 6, 0 );
    	this.addSmeltingCycle(Items.iron_helmet, Items.iron_ingot, 3, 0);
    	this.addSmeltingCycle(Items.iron_leggings, Items.iron_ingot, 5, 0);  
    	
    	this.addSmeltingCycle(Items.shears, Items.iron_ingot, 1, 0);
    	this.addSmeltingCycle(Items.bucket, Items.iron_ingot, 2, 0);
    	this.addSmeltingCycle(Items.cauldron, Items.iron_ingot, 2,0);
    	this.addSmeltingCycle(Items.minecart, Items.iron_ingot, 4,0);
    	this.addSmeltingCycle(Items.iron_door, Items.iron_ingot, 2,0);    	    	
    	this.addSmeltingCycle(Blocks.iron_bars.getItem(null, null), Items.iron_ingot, 4,0);
    	this.addSmeltingCycle(Blocks.cauldron.getItem(null, null), Items.iron_ingot, 3, 0);
    	this.addSmeltingCycle(Blocks.hopper.getItem(null,null), Items.iron_ingot, 3, 0);
    	
    }
    
    private void addGoldenItems(){
    	this.addSmeltingCycle(Items.golden_sword, Items.gold_nugget, 13, 0);
    	this.addSmeltingCycle(Items.golden_axe, Items.gold_nugget, 17, 0);
    	this.addSmeltingCycle(Items.golden_hoe, Items.gold_nugget, 13, 0);
    	this.addSmeltingCycle(Items.golden_horse_armor, Items.gold_nugget, 36,0);
    	this.addSmeltingCycle(Items.golden_pickaxe, Items.gold_nugget, 17,0);
    	this.addSmeltingCycle(Items.golden_shovel, Items.gold_nugget, 6, 0);
    	this.addSmeltingCycle(Items.golden_boots, Items.gold_nugget, 30,0 );
    	this.addSmeltingCycle(Items.golden_chestplate, Items.gold_nugget, 47,0 );
    	this.addSmeltingCycle(Items.golden_helmet, Items.gold_nugget, 47, 0);
    	this.addSmeltingCycle(Items.golden_leggings, Items.gold_nugget, 42, 0);
    }
}
