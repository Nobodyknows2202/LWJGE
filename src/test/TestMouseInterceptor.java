package test;

import com.Brink.LWJGE.input.MouseCombo;
import com.Brink.LWJGE.input.MouseInterceptor;

public class TestMouseInterceptor extends MouseInterceptor {
	
	public TestMouseInterceptor(MouseCombo[] positions){
		for (MouseCombo mouseCombo : positions) {
			this.positions.add(mouseCombo);
		}
	}
	
	public void mouseAction(MouseCombo position) {
		System.out.println("Actioning");
		Test.game.findEntity(1).addVelX(5);
		Test.game.findEntity(1).addVelY(5);
	}

	public void resetPosition(){
		this.positions.get(0).x1 = Test.game.findEntity(1).getX();
		this.positions.get(0).x2 = Test.game.findEntity(1).getX() + 32;
		this.positions.get(0).y1 = Test.game.findEntity(1).getY();
		this.positions.get(0).y2 = Test.game.findEntity(1).getY() + 32;
	}
	
}
