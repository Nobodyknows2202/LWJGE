package test;

import static org.lwjgl.glfw.GLFW.*;

import com.Brink.LWJGE.input.KeyInterceptor;

public class TestInterceptor extends KeyInterceptor {
	
	public TestInterceptor(int[] keys){
		for (int key : keys) {
			this.wantedKeys.add(key);	
		}
	}
	
	public void keyAction(int key, int action) {
		if(action != GLFW_RELEASE){
			switch(key){
			case GLFW_KEY_ESCAPE:
				Test.game.stop(); break;
			case GLFW_KEY_W:
				Test.game.findEntity(0).addVelY(10); break;
			case GLFW_KEY_A:
				Test.game.findEntity(0).addVelX(-10); break;
			case GLFW_KEY_S:
				Test.game.findEntity(0).addVelY(-10); break;
			case GLFW_KEY_D:
				Test.game.findEntity(0).addVelX(10); break;
			}
		}
	}
	
}
