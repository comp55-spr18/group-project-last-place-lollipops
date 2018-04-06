import java.awt.Color;

public class Rock extends Entity {
	//102- 51- 0
	public Rock(double speed, int size, double x, double y, Color color) { 		
		setSpeed(speed);
		color = new Color(102, 51, 0);
		setColor(color);
	}
	
	//function for what rock is gonna do
	public void hitRock() {
		
	}
}
