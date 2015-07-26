package com.queennuffer.smeltcycle;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameData;

public class SmeltRecipe {
	private Item _itemIn;
	private Item _itemOut;
	private int _outCount;
	private float _expOut;
	
	
	public boolean isFor(Item item){
		return (getItemName(_itemIn).equals(getItemName(item)));
	}
	
	public boolean isFor(SmeltRecipe r){
		return (getItemName(_itemIn).equals(getItemName(r.getItemIn())));
	}
	
	public void updateToMatch(SmeltRecipe r){
		_itemOut = r.getItemOut();
		_outCount = r.getResultSize();
		_expOut = r.getResultExp();
	}
	
	public SmeltRecipe(Item itemIn, Item itemOut, int outCount, float expOut){
		_itemIn = itemIn;
		_itemOut = itemOut;
		_outCount = outCount;
		_expOut = expOut;		
	}
	
	public SmeltRecipe(String fromLine){
		String[] itemData = fromLine.split(",");		
		_itemIn = getItem(itemData[0]);
		_itemOut = getItem(itemData[1]);
		_outCount = Integer.parseInt(itemData[2]);
		_expOut = Float.parseFloat(itemData[3]);
	}
	
	/* Shortcut method just to make the code easier to read */
	private String getItemName(Item item){
		return GameData.getItemRegistry().getNameForObject(item).toString();		
	}
	
	public String toString(){		
		String line = getItemName(_itemIn) + ",";
		line += getItemName(_itemOut) + ",";
		line += Integer.toString(_outCount) + "," + Float.toString(_expOut);
		return line;		
	}
	
	private Item getItem(String fromString){
		return GameData.getItemRegistry().getObject(fromString);
	}
	
	public Item getItemIn(){
		return _itemIn;
	}
	
	public Item getItemOut(){
		return _itemOut;
	}
	
	public int getResultSize(){
		return _outCount;
	}
	
	public float getResultExp(){
		return _expOut;
	}

}
