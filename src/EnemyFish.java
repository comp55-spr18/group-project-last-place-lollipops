import java.awt.Color;
import java.util.ArrayList;

public class EnemyFish extends Fish{
	private ArrayList<Fish> enemies =  new ArrayList<Fish>();

	//constructor
	public EnemyFish(double speed, int size, double x, double y, Color color) {
		setSpeed(speed);
		setSize(size);
		setColor(Color.red);
	}
	
	//functions
	public void addEnemyFish() {
		for(Fish f: enemies) {
			// *** add fishes ***
		}
	}
	
	//public void moveEnemy() ???
}
