package com.Brink.LWJGE.input;

import java.util.ArrayList;

public abstract class MouseInterceptor {
	public ArrayList<MouseCombo> positions = new ArrayList<>();
	
	public abstract void mouseAction(MouseCombo position);
}
