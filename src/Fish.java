import java.awt.*;
import java.util.ArrayList;
import acm.graphics.GImage;
import acm.graphics.GScalable;

public class Fish extends Entity { // Player inherits from this class
	public boolean RtL = true;
	private int size;
	
	
	// constructor
	public Fish(MainApplication program) {
		int leftOrRight = program.rgen.nextInt(0, 1);
		int topOrBottom = program.rgen.nextInt(0, 600);
		
		if(!(this instanceof Player)) {
			if (leftOrRight == 0) {

				img = new GImage("SmallFryFlipped.png", 0, topOrBottom);

				program.getGame().fishLtoR.add(this);
				RtL = false;
			} else {
				img = new GImage("SmallFry.png", 630 ,topOrBottom);
				program.getGame().fishRtoL.add(this);
				RtL = true;
			}
		} else {
			img = new GImage("PlainOldFish.png", program.WINDOW_WIDTH/2, program.WINDOW_HEIGHT/2);
		}
		
	}

	// getters and setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public GImage getFish() {
		return img;
	}

	public void setFish(String fish) {
		img.setImage(fish);
	}
	
	public boolean getRTL() {
		return RtL;
	}
	
	public void setRTL(boolean boo) {
		RtL = boo;
	}

}
