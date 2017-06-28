package test;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import com.Brink.LWJGE.Engine;
import com.Brink.LWJGE.game.Game;
import com.Brink.LWJGE.graphics.RGBA;
import com.Brink.LWJGE.graphics.SpritesheetHandler;
import com.Brink.LWJGE.input.*;

public class Test {
	
	public static Game game;
	public static MouseHandler mouseHandler;

	public static void main(String[] args){
		System.out.println("Hello World!");
		
		Engine.init(500, 400, new RGBA(1f, 1f, 1f, 1f));
		
		SpritesheetHandler.addSheet("Test", "src/test/res/TestSheet.png", 32, 32);
		ArrayList<KeyInterceptor> test = new ArrayList<>(); test.add(new TestInterceptor(new int[]{
				GLFW_KEY_ESCAPE, GLFW_KEY_W, GLFW_KEY_A, GLFW_KEY_S, GLFW_KEY_D, GLFW_KEY_SPACE
		}));
		ArrayList<MouseInterceptor> mouse = new ArrayList<>(); mouse.add(new TestMouseInterceptor(new MouseCombo[]{
			new MouseCombo(200, 232, 150, 182, GLFW_MOUSE_BUTTON_LEFT, GLFW_PRESS, 1)	
		}));
		mouse.add(new TestMouseInterceptor(new MouseCombo[]{
			new MouseCombo(20, 70, 32, 82, GLFW_MOUSE_BUTTON_LEFT, GLFW_PRESS, 2)
		}));
		Engine.startKeyHandler(test, 0);
		Engine.startMouseHandler(mouse, 0);

		
		game = new Game();
		game.start("Test", new TestLink());
	}
	
}
