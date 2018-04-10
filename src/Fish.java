import java.awt.*;
import java.util.ArrayList;
import acm.graphics.GImage;

public class Fish extends Entity { // Player inherits from this class
	private int size;
	private MainApplication program;

	public GImage fishImage;
	

	// constructor
	public Fish(MainApplication program) {
		setSize(size);
		System.out.println("Making a fish()\n");
		int random = program.rgen.nextInt(0, 1);
		System.out.println("random: " + random);
		if (random == 0) {
			fishImage = new GImage("SmallFryFlipped.png", 0, program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			program.fishLtoR.add(this);
		} else {
			fishImage = new GImage("SmallFry.png", program.WINDOW_WIDTH, program.rgen.nextInt(0, program.WINDOW_HEIGHT));
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
}
