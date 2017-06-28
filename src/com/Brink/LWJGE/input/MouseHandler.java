package com.Brink.LWJGE.input;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class MouseHandler extends GLFWMouseButtonCallback {
	public ArrayList<MouseInterceptor> interceptors;
	
	public MouseHandler(ArrayList<MouseInterceptor> interceptors){
		this.interceptors = interceptors;
	}
	
	public void invoke(long window, int button, int action, int mods) {
		for(MouseInterceptor mouseInterceptor : interceptors) {
			for(MouseCombo position : mouseInterceptor.positions) {
				if((CursorHandler.xpos >= position.x1 && CursorHandler.xpos <= position.x2) && (CursorHandler.ypos >= position.y1 && CursorHandler.ypos <= position.y2)){
					if(position.button == button && position.action == action){
						mouseInterceptor.mouseAction(position);
					}
				}
			}
		}
	}
	
}
