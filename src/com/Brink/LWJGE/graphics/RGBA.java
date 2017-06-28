package com.Brink.LWJGE.graphics;

public class RGBA {
	public float red, green, blue, alpha;
	
	public RGBA(int red, int green, int blue, int alpha){
		this.red = (float)red / 255;
		this.green = (float)green / 255;
		this.blue = (float)blue / 255;
		this.alpha = (float)alpha / 255;
	}
	
	public RGBA(float red, float green, float blue, float alpha){
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
}
