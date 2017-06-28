package com.Brink.LWJGE.graphics;

import java.util.ArrayList;

public class SpritesheetHandler {
	public static ArrayList<Spritesheet> spritesheets = new ArrayList<Spritesheet>();
	
	public static Spritesheet getSheet(String name){
		for (Spritesheet spritesheet : spritesheets) {
			if(spritesheet.name == name){
				return spritesheet;
			}
		}
		
		return null;
	}
	
	public static void addSheet(String name, String path, int spriteSizeX, int spriteSizeY){
		spritesheets.add(new Spritesheet(name, path, spriteSizeX, spriteSizeY));
	}
}
