package com.queennuffer.smeltcycle;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameData;


public class SmeltCycleCommand implements ICommand{
	private List aliases;
	
	private static String _helpText = "smeltcycle add <item_to_smelt_id> <item_to_return_id> <return_count> <exp>\nsmeltcycle remove <item_to_smelt_id>";

	public SmeltCycleCommand(){
		this.aliases = new ArrayList();
		this.aliases.add("smelt");
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "smeltcycle";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return _helpText;
	}

	@Override
	public List getAliases() {
		return this.aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		if(args.length == 0){
			sendChatError(sender, "Invalid arguments");
		}else{
			if(args[0].toLowerCase().equals("add")){
				if(args.length != 5){
					sendChatError(sender, "Invalid arguments");					
				}else{
					Item itemIn = GameData.getItemRegistry().getObject(args[1]);
					if(itemIn==null){
						sendChatError(sender,"Invalid item " + args[1]);
						return;
					}					
					Item itemOut = GameData.getItemRegistry().getObject(args[2]);
					if(itemOut==null){
						sendChatError(sender,"Invalid item " + args[2]);
						return;
					}			
					int stackOut = 0;
					try{
						stackOut = Integer.parseInt(args[3]);
						if(stackOut < 1 || stackOut > 64){
							sendChatError(sender,"Return quantity must be an integer between 1 and 64 inclusive");
							return;						
						}
					}catch(Exception e){
						sendChatError(sender,"Return quantity must be an integer between 1 and 64 inclusive");
						return;
					}
					float smeltExp = 0;
					try{
					 smeltExp = Float.parseFloat(args[4]);
					 if(smeltExp < 0){
							sendChatError(sender,"Experience must be a positive numeric value");
							return;
					 }
					}catch(Exception e){
						sendChatError(sender,"Experience must be a positive numeric value");
						return;
					}
					SmeltCycle.proxy.addRecipe(itemIn, itemOut, stackOut, smeltExp);
					sendChatSuccess(sender,"Recipe added for " + itemIn.getUnlocalizedName());
				}
			}else if(args[0].toLowerCase().equals("remove")){
				if(args.length != 2){
					sendChatError(sender, "Invalid number of arguments");
					return;
				}else{
					Item removeItem = GameData.getItemRegistry().getObject(args[1]);
					SmeltCycle.proxy.config.removeRecipe(removeItem);
					sendChatSuccess(sender,"Recipe removed - please restart the game");
				}				
			}else{
				sendChatError(sender, "Invalid command " + args[0]);
			}
		}		
	}
	
	private void sendChatSuccess(ICommandSender sender, String msg){
		ChatComponentText chat = new ChatComponentText(msg);
		chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
		sender.addChatMessage(chat);		
	}
	
	private void sendChatError(ICommandSender sender, String msg){
		ChatComponentText chat = new ChatComponentText(msg);
		chat.getChatStyle().setColor(EnumChatFormatting.RED);
		sender.addChatMessage(chat);
		
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		ServerConfigurationManager sm = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager();
		Entity ent = sender.getCommandSenderEntity();
		if(ent == null) return false;
		if(ent instanceof EntityPlayer){
			EntityPlayer ep = (EntityPlayer) ent;
			return sm.canSendCommands(ep.getGameProfile());
		}else{
			return false;
		}
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
