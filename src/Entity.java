//kevin
import java.awt.*;

import acm.graphics.GImage;
public class Entity {
	private double speed;

	protected Color color;

	private GImage image; // for sprites ("image name.png", x, y)

	public double getSpeed() {
		return speed;
	}

	public Color getColor() {
		return color;
	}
	public GImage getImage() {
		return image;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}