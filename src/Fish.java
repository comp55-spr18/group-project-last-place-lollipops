import java.awt.*;
import java.util.ArrayList;
import acm.graphics.GImage;

public class Fish extends Entity{ // EnemyFish & Player inherit from this class
	private int size; // size matters only for fish
	
	//getters & setters
	public int getSize() { 
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	// functions that both player fish & enemyFish would use

}
