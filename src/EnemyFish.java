import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;

public class EnemyFish extends Fish {
	private ArrayList<Fish> enemies =  new ArrayList<Fish>();

	//constructor
	public EnemyFish(GImage g, double speed, int size, double x, double y, Color color) {
		setSpeed(speed);
		setSize(size);
		setxPosition(x);
		setyPosition(y);
		setColor(Color.red);
	}
	
	/*public void setImage(int size) { // sets different images of fishes to different sizes
	 	switch(size) {
	 		case 0: //guppie
	 			// set GImage of guppie to fish in arraylist
	 		case 1: // cod
	 			// set GImage of cod 
	 		case 2: // salmon
	 			// repeat
	 		default: //idk
	 }
	 */
	
	//functions
	public void addEnemyFish() {
		for(Fish f: enemies) {
			// *** add fishes ***
		}
	}
	
	//public void moveEnemy() ???
}
