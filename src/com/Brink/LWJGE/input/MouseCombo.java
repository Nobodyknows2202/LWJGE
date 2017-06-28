package com.Brink.LWJGE.input;

public class MouseCombo {
	public float x1, x2, y1, y2;
	public int button, action, id;
	
	public MouseCombo(float x1, float x2, float y1, float y2, int button, int action, int id){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.button = button;
		this.action = action;
		this.id = id;
	}
	
}
