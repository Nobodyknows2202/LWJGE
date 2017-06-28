package com.Brink.LWJGE.input;

import org.lwjgl.glfw.GLFWCursorPosCallback;

import com.Brink.LWJGE.Engine;

public class CursorHandler extends GLFWCursorPosCallback {
	public static double xpos, ypos;
	
	public void invoke(long window, double xpos, double ypos) {
		CursorHandler.xpos = xpos;
		CursorHandler.ypos = Engine.height - ypos;
	}
	
}
