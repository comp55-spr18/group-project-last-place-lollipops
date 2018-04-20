import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GScalable;

public class Garbage extends Entity{
	private int degree = 90;

	public Garbage() {
		img = new GImage("newsodarings.png", -20,  MainApplication.WINDOW_HEIGHT/2);		
		img.scale(0.25);

	}

	//getters, don't need setters because image will never change
	public GImage getGarbageImage() {
		return img;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	
}

