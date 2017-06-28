package com.Brink.LWJGE.input;

import java.util.ArrayList;

public abstract class KeyInterceptor {
	protected ArrayList<Integer> wantedKeys = new ArrayList<Integer>();
	
	public abstract void keyAction(int key, int action);
	
	public ArrayList<Integer> getWantedKeys(){
		return wantedKeys;
	}
}
