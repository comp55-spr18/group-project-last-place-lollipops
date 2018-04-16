import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GScalable;
import acm.util.RandomGenerator;

public class Garbage extends Entity{
	private RandomGenerator rgen = new RandomGenerator();
	private GImage garbageImage;
	private MainApplication program;
	
	public Garbage(MainApplication program, double speed) {
		setSpeed(speed);
		garbageImage = new GImage("plastic rings.png", 0,  100);		
		garbageImage.scale(0.5);
	}
	
	//getters, don't need setters because image will never change
	public GImage getGarbageImage() {
		return garbageImage;
	}
	
	//functions for what garbage does
	public void addGarbage() {
		program.add(garbageImage);
	}
	
	public void removeGarbage() {
		program.remove(garbageImage);
	}
	
	public void moveGarbage() {
		int random = rgen.nextInt(-2, 2);
		if (random == 0) {
			//kelpImage.add(this);
		} else {
			rgen.nextInt(0, program.WINDOW_HEIGHT);
			//add(this);
		}
		garbageImage.move(3, rgen.nextInt(-2, 2));
	}
	
	public void hitGarbage() {
		
	}

}

