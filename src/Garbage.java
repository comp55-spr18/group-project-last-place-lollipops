import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GScalable;
import acm.util.RandomGenerator;

// *** Want to change kelp to insta-kill garbage ***
public class Kelp extends Entity{
	private RandomGenerator rgen;
	private GImage kelpImage;
	private MainApplication program;
	
	public Kelp(MainApplication program, double speed) {
		setSpeed(speed);
		kelpImage = new GImage("kelp.png", 0,  100);		
		kelpImage.scale(0.5);
	}
	
	//getters, don't need setters because image will never change
	public GImage getKelpImage() {
		return kelpImage;
	}
	
	//functions for what kelp does
	public void addKelp() {
		program.add(kelpImage);
	}
	
	public void removeKelp() {
		program.remove(kelpImage);
	}
	
	public void moveKelp() {
		int random = program.rgen.nextInt(0, 1);
		if (random == 0) {
			//kelpImage.add(this);
		} else {
			program.rgen.nextInt(0, program.WINDOW_HEIGHT);
			//add(this);
		}
		kelpImage.move(3, rgen.nextInt(-2, 2));
	}
	
	public void hitKelp() {
		
	}

}

