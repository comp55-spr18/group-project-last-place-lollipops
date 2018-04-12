import java.awt.*;
import java.util.ArrayList;
import acm.graphics.GImage;
import acm.graphics.GScalable;

public class Fish extends Entity { // Player inherits from this class
	private int size;
	private int sizeCounter = 1;
	private MainApplication program;
	private GScalable scale;


	public GImage fishImage;

	// constructor
	public Fish(MainApplication program) {
		setSize(size);
		int random = program.rgen.nextInt(0, 1);
		if (random == 0) {
			fishImage = new GImage("SmallFryFlipped.png", 0, program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			program.fishLtoR.add(this);
		} else {
			fishImage = new GImage("SmallFry.png", program.WINDOW_WIDTH,
			program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			program.fishRtoL.add(this);
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

	public void setFish(GImage fish) {
		/*
		 * not intended for boss fish! do not use for kingofthepond or mysteryfish
		 */
		this.fishImage = fish;
		this.fishImage.setSize(90, 90);
		obj = this.fishImage;
	}

	public int getSizeCounter() {
		return sizeCounter;
	}

	public void setSizeCounter(int sizeCounter) {
		this.sizeCounter = sizeCounter;
	}

	public void grow() {
		this.fishImage.scale(1.25);
		sizeCounter++;
	}
	
	

}
