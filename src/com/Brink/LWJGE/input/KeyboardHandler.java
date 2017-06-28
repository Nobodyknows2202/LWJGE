package com.Brink.LWJGE.input;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyboardHandler extends GLFWKeyCallback {
	private static ArrayList<KeyInterceptor> keyInterceptors;
	
	public KeyboardHandler(ArrayList<KeyInterceptor> keyInterceptors){
		KeyboardHandler.keyInterceptors = keyInterceptors;
	}
	
	public void invoke(long window, int key, int scancode, int action, int mods){
		for (KeyInterceptor keyInterceptor : keyInterceptors) {
			for(int wantedKey : keyInterceptor.getWantedKeys()){
				if(key == wantedKey){
					keyInterceptor.keyAction(key, action);
				}
			}
		}
	}
	
}
