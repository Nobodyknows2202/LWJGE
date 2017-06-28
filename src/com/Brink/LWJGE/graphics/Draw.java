package com.Brink.LWJGE.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Draw {
	
	public static void rect(float x, float y, float w, float h, RGBA color){rect(x, y, w, h, color, 0f);}
	public static void rect(float x, float y, float w, float h, RGBA color, float rot){
		glPushMatrix();
		{
			glColor4f(color.red, color.green, color.blue, color.alpha);
			glTranslatef(x, y, 0);
			glRotatef(rot, 0, 0, 1);
			glBegin(GL_QUADS);
			{
				glVertex2f(0, 0);
				glVertex2f(0, h);
				glVertex2f(w, h);
				glVertex2f(w, 0);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public static void sprite(float x, float y, float w, float h, String spriteName, int spriteNum){sprite(x, y, w, h, spriteName, spriteNum, 0f);}
	public static void sprite(float x, float y, float w, float h, String spriteName, int spriteNum, float rot){
		for (Spritesheet spritesheet : SpritesheetHandler.spritesheets) {
			if(spritesheet.name == spriteName){
				sprite(x, y, w, h, spritesheet.ID, spriteNum, rot);
			}
		}
	}
	public static void sprite(float x, float y, float w, float h, int spriteId, int spriteNum){sprite(x, y, w, h, spriteId, spriteNum, 0f);}
	public static void sprite(float x, float y, float w, float h, int spriteId, int spriteNum, float rot){
		glPushMatrix();
		{
			glColor4f(1, 1, 1, 1);
			glTranslatef(x, y, 0);
			glRotatef(rot, 0, 0, 1);
			Spritesheet sheet = null;
			for (Spritesheet spritesheet : SpritesheetHandler.spritesheets) {
				if(spritesheet.ID == spriteId){
					sheet = spritesheet;
				}
			}
			glBindTexture(GL_TEXTURE_2D, sheet.ID);
			glBegin(GL_QUADS);
			{
				int numX = (spriteNum % (sheet.width / sheet.spriteSizeX)),
				numY = (int)(spriteNum / (sheet.height / sheet.spriteSizeY));
				float x1 = ((float)numX - 1f) / (sheet.width / sheet.spriteSizeX),
				x2 = (float)numX / (sheet.width / sheet.spriteSizeX),
				y1 = (float)numY / (sheet.height / sheet.spriteSizeY),
				y2 = ((float)numY + 1f) / (sheet.height / sheet.spriteSizeY);
				glTexCoord2f(x1, y1); glVertex2f(0, h);
				glTexCoord2f(x2, y1); glVertex2f(w, h);
				glTexCoord2f(x2, y2); glVertex2f(w, 0);
				glTexCoord2f(x1, y2); glVertex2f(0, 0);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
}
