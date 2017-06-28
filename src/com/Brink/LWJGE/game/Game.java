package com.Brink.LWJGE.game;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import org.lwjgl.opengl.GLContext;

import com.Brink.LWJGE.Engine;

public class Game implements Runnable {
	public GameState state = GameState.Stopped;
	
	private ArrayList<Entity> entities;
	private GameLink gameLink;
	
	public Thread thread;
	
	public void start(String name, GameLink gameLink){
		entities = new ArrayList<Entity>();
		state = GameState.Running;
		this.gameLink = gameLink;
		thread = new Thread(this, name);
		thread.start();
	}
	
	public void stop(){
		state = GameState.Stopped;
	}
	
	public void run() {
		glfwMakeContextCurrent(Engine.getWindow());
		GLContext.createFromCurrent();
		gameLink.init();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		while(state == GameState.Running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				if(glfwWindowShouldClose(Engine.getWindow()) == GL_TRUE)
					state = GameState.Stopped;
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
//				System.out.println("Entities:");
//				for (Entity entity : entities) {
//					System.out.println(entity.toString());
//				}
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void tick(){
		glfwPollEvents();
		
		for (Entity entity : entities) {
			entity.tick();
		}
	}
	
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		
		for (Entity entity : entities) {
			entity.render();
		}
		
		glfwSwapBuffers(Engine.getWindow());
	}
	
	public void addEntity(Entity entity){
		this.entities.add(entity);
	}
	
	public Entity findEntity(int id){
		for (Entity entity : entities) {
			if(entity.getId() == 1){
				return entity;
			}
		}
		
		return null;
	}
	
}
