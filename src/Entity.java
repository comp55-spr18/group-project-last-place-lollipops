//kevin
import java.awt.*;

import acm.graphics.GImage;
public class Entity {
	private double speed;
	private GImage image; // for sprites ("image name.png", x, y)

	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}