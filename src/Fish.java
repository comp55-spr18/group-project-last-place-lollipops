import java.awt.*;
import java.util.ArrayList;
import acm.graphics.GImage;
import acm.graphics.GScalable;

public class Fish extends Entity { // Player inherits from this class
	private int size;
	public boolean RtL;
	public GImage fishImage;

	// constructor
	public Fish(MainApplication program) {
		int leftOrRight = program.rgen.nextInt(0, 1);
		int topOrBottom = program.rgen.nextInt(0, 600);
		
		if(!(this instanceof Player)) {
			if (leftOrRight == 0) {
				fishImage = new GImage("SmallFryFlipped.png", 0, topOrBottom);
				program.fishLtoR.add(this);
				RtL = false;
			} else {
				fishImage = new GImage("SmallFry.png", 630 ,topOrBottom);
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
		
		fishImage.setImage(fish);
		fishImage.setSize(90, 90);
		obj = fishImage;
	}

}
