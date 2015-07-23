package com.queennuffer.smeltcycle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.config.Configuration.UnicodeInputStreamReader;

public class SmeltingConfig {
	private Item _itemIn;
	private Item _itemOut;
	private int _outQuantity;
	private float _outExp;
	private File file;
	
	public SmeltingConfig(File loadFrom){
		file = loadFrom;		
	}
	
	public void load(){
        /*BufferedReader buffer = null;
        UnicodeInputStreamReader input = null;
        try{
	        if (file.getParentFile() != null){
	            file.getParentFile().mkdirs();
	        }

            if (!file.exists()){
                if (!file.createNewFile())
                    return;
            }

            if (file.canRead()){
                input = new UnicodeInputStreamReader(new FileInputStream(file), "UTF-8");
                buffer = new BufferedReader(input);

                String line;
                ConfigCategory currentCat = null;
                Property.Type type = null;
                ArrayList<String> tmpList = null;
                int lineNum = 0;
                String name = null;

                while (true)
                {
                    lineNum++;
                    line = buffer.readLine();

                    if (line == null)
                    {
                        if (lineNum == 1)
                            loadedConfigVersion = definedConfigVersion;
                        break;
                    }

                    Matcher start = CONFIG_START.matcher(line);
                    Matcher end = CONFIG_END.matcher(line);

                    if (start.matches())
*/	
	}
	
	public String toString(){
		return "";
		
	}

}
