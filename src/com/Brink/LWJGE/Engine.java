package com.Brink.LWJGE;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.opengl.GLContext;

import com.Brink.LWJGE.graphics.RGBA;
import com.Brink.LWJGE.input.*;

public class Engine {
	
	public static int width, height;

	private static KeyboardHandler[] keyboardHandlers = new KeyboardHandler[2048];
	private static MouseHandler[] mouseHandlers = new MouseHandler[2048];
	private static CursorHandler cursorHandler;

	private static long window; public static long getWindow(){return window;}
	
	public static void init(int width, int height){init(width, height, new RGBA(1f, 1f, 1f, 1f));}
	public static void init(int width, int height, RGBA clearColor){
		Engine.width = width;
		Engine.height = height;
		
		if(glfwInit() != GL_TRUE){
			System.out.println("Could not init GLFW!");
			return;
		}
		
		//ByteBuffer vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(width, height, "Test", NULL, NULL);
		if(window == NULL){
			System.out.println("Could not make window!");
			return;
		}
		
		glfwSetCursorPosCallback(window, (cursorHandler = new CursorHandler()));
		
		glfwSetWindowPos(window, 1024, 1024);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		GLContext.createFromCurrent();
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, 0, height, -1, 1);
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_ALPHA_TEST);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glClearColor(clearColor.red, clearColor.green, clearColor.blue, clearColor.alpha);
		glColor4f(1, 1, 1, 1);
		glDisable(GL_DEPTH_TEST);
		System.out.println("OpenGL: " + glGetString(GL_VERSION));
	}
	
	public static GLFWKeyCallback startKeyHandler(ArrayList<KeyInterceptor> interceptors, int keyHandlerId){
		glfwSetKeyCallback(window, (keyboardHandlers[keyHandlerId] = new KeyboardHandler(interceptors)));
		return keyboardHandlers[keyHandlerId];
	}
	
	public static GLFWMouseButtonCallback startMouseHandler(ArrayList<MouseInterceptor> interceptors, int mouseHandlerId) {
		glfwSetMouseButtonCallback(window, (mouseHandlers[mouseHandlerId] = new MouseHandler(interceptors)));
		return mouseHandlers[mouseHandlerId];
	}

}
