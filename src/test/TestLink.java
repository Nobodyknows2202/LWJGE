package test;

import com.Brink.LWJGE.game.GameLink;
import com.Brink.LWJGE.graphics.RGBA;

public class TestLink extends GameLink {
	
	public void init(){
		Test.game.addEntity(new SquareEntity(200, 150, 32, 32, new RGBA(255, 0, 0, 255)));
	}
	
}
