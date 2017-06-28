package com.Brink.LWJGE.game;

public abstract class Entity {
	protected float w, h, x, y, velX, velY, rot;
	public int spriteNum = 1;
	
	public Entity(float w, float h, float x, float y, float rot){
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
		this.rot = rot;
	}
	
	public abstract void tick();
	public abstract void render();
	public abstract int getId();
	
	public void addVelX(float velX){
		this.velX += velX;
	}
	
	public void addVelY(float velY){
		this.velY += velY;
	}
	
	@Override
	public abstract String toString();

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
