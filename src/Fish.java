import java.awt.*;
import acm.graphics.GImage;

public class Fish extends Entity{
	private int sizeCounter = 1;
	private GImage fish;
	
	public GImage getFish() {
		return fish;
	}
	public void setFish(GImage fish) {
		/*
		 * not intended for boss fish! 
		 * do not use for kingofthepond or mysteryfish
		 */
		this.fish = fish;
		this.fish.setSize(90,90);
		obj = this.fish;
	}
	public int getSizeCounter() { 
		return sizeCounter;
	}
	public void setSizeCounter(int sizeCounter) {
		this.sizeCounter = sizeCounter;
	}
	public void grow() {
		this.fish.scale(1.25);
		sizeCounter++;
	}
	
	
	
}
