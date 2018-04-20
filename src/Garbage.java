import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GScalable;
import acm.util.RandomGenerator;

public class Garbage extends Entity{
	private RandomGenerator rgen = new RandomGenerator();
	private GImage garbageImage;
	private MainApplication program;
	private int degree = 90;
	private int x = -50;
	private int y = program.WINDOW_HEIGHT/2;
	private int count = 0;
	
	public Garbage() {
		//program = app;
		garbageImage = new GImage("newsodarings.png", x, y);		
		garbageImage.scale(0.25);
		obj = garbageImage;
	}
	
	//getters, don't need setters because image will never change
	public GImage getGarbageImage() {
		return garbageImage;
	}
	
//	public void moveGarbage() {
//			degree += 5;
//			if(degree % 90 == 0) {
//				rgen.nextInt(0, program.WINDOW_HEIGHT);
//				garbageImage.movePolar(2, degree % ((360*2)-360)); //needs to be 0 - 90 and 270-360 OR negative (0 - 90)
//			}
//	}
	
	public void move(int i, int j) {
		count++;
		garbageImage.move(i, Math.sin(count)*5);
	}
}

