package test;

import com.Brink.LWJGE.game.Entity;
import com.Brink.LWJGE.graphics.Draw;
import com.Brink.LWJGE.graphics.RGBA;

public class SquareEntity extends Entity {
	
	RGBA color;
	
	public SquareEntity(float x, float y, float w, float h, RGBA color) {
		super(w, h, x, y, 0);
		this.color = color;
	}
	
	public void tick() {
		this.x += this.velX;
		this.y += this.velY;
		
		this.velX *= 0.8f;
		this.velY *= 0.8f;
	}
	
	public void render() {
		Draw.rect(x, y, w, h, color);
	}
	
	public int getId() {
		return 1;
	}
	
	@Override
	public String toString(){
		return "Square entity";
	}
	
}
