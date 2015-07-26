package com.queennuffer.smeltcycle;

import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = SmeltCycle.MODID, name="SmeltCycle", version = SmeltCycle.VERSION, acceptableRemoteVersions = "*")
public class SmeltCycle
{
	@Instance("SmeltCycle")
	public static SmeltCycle instance;

	@SidedProxy(clientSide="com.queennuffer.smeltcycle.ClientProxy", serverSide="com.queennuffer.smeltcycle.ServerProxy")
	public static ServerProxy proxy;

    public static final String MODID = "SmeltCycle";
    public static final String VERSION = "2.0";
    
    public SmeltCycle(){
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	proxy.doPreInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing SmeltCycle");
        proxy.doInit(event);      
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    	event.registerServerCommand(new SmeltCycleCommand());
    }
}
