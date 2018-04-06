//kevin
import java.awt.*;

import acm.graphics.GImage;
public abstract class Entity  {
	private double speed;
	private Color color;
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
	//GImage does not need a setter

}