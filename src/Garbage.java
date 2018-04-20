import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GScalable;

public class Garbage extends Entity{
	private int degree = 90;
	private int x = -150;
	private int y = MainApplication.WINDOW_HEIGHT/2;
	private int count = 0;

	public Garbage() {
		img = new GImage("newsodarings.png", x,  y);		
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

	
//	public void moveGarbage() {
//			degree += 5;
//			if(degree % 90 == 0) {
//				rgen.nextInt(0, program.WINDOW_HEIGHT);
//				garbageImage.movePolar(2, degree % ((360*2)-360)); //needs to be 0 - 90 and 270-360 OR negative (0 - 90)
//			}
//	}
	
	public void move(int i, int j) {
		count++;
		if(Math.sin(count/150)>0) {
			img.move((double)i/2, (double)-j/2);
			return;
		}
		img.move((double)i/2, (double)j/2);
		if(img.getX()<0) {
			
		}
	}

}

