import java.awt.*;
import java.util.ArrayList;
import acm.graphics.GImage;
import acm.graphics.GScalable;

public class Fish extends Entity { // Player inherits from this class
	public boolean RtL;
	private int size;
	private int sizeCounter = 1;
	private MainApplication program;
	private GScalable scale;

	public GImage fishImage;

	// constructor
	public Fish(MainApplication program) {
		int random = program.rgen.nextInt(0, 1);
		int random1 = program.rgen.nextInt(0, 600);
		if(!(this instanceof Player)) {
			if (random == 0) {
				fishImage = new GImage("SmallFryFlipped.png", 0, random1);
				program.fishLtoR.add(this);
				RtL = false;
			} else {
				fishImage = new GImage("SmallFry.png", 630 ,random1);
				program.fishRtoL.add(this);
				RtL = true;
			}
		} else {
			fishImage = new GImage("PlainOldFish.png", program.WINDOW_WIDTH/2, program.WINDOW_HEIGHT/2);
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
		return fishImage;
	}

	public void setFish(String fish) {
		/*
		 * not intended for boss fish! do not use for kingofthepond or mysteryfish
		 */
		fishImage.setImage(fish);
		fishImage.setSize(90, 90);
		obj = fishImage;
	}

	public int getSizeCounter() {
		return sizeCounter;
	}

	public void setSizeCounter(int sizeCounter) {
		this.sizeCounter = sizeCounter;
	}
	
	// make switch statement to create enemy fishes and different sizes and images
	

}
