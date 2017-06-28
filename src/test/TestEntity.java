package test;

import com.Brink.LWJGE.game.Entity;
import com.Brink.LWJGE.graphics.Draw;

public class TestEntity extends Entity {
	
	private int id = 1;
	
	public TestEntity(float x, float y, float w, float h, int id){
		super(w, h, x, y, 0);
		this.id = id;
	}
	public TestEntity(float x, float y, float w, float h){
		super(w, h, x, y, 0);
	}
	
	public void render(){
		Draw.sprite(x, y, w, h, "Test", this.spriteNum);
	}
	
	public void tick(){
		this.x += this.velX;
		this.y += this.velY;
		
		this.velX *= 0.8f;
		this.velY *= 0.8f;

		//Test.mouse.get(0).positions.get(0).x1 = x;
		//Test.mouse.get(0).positions.get(0).x2 = x + 32;
		//Test.mouse.get(0).positions.get(0).y1 = y;
		//Test.mouse.get(0).positions.get(0).y2 = y + 32;
	}
	
	public int getId(){
		return this.id;
	}
	
	@Override
	public String toString(){
		return "Test Entity";
	}
	
}
