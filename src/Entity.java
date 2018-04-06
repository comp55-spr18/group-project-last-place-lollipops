//kevin
import java.awt.*;

import acm.graphics.GImage;
public abstract class Entity  {
	private double speed;
	protected Color color;
	private GImage image; // for sprites ("image name.png", x, y)

	

	public double getSpeed() {
		return speed;
	}
	public Color getColor() {
		return color;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setColor(Color color) {
		this.color = color;
	}

//	public void collidedWith(EntityType e, int s) { // object entity e, size s
//		switch(e) { // ***print statements are only for testing***
//			case KELP: 
//				System.out.println("Kelp has been called\n");
//			case HOOK: 
//				System.out.println("Hook has been called\n");
//			case FISH: 
//				System.out.println("Fish has been called\n");
//			case ROCK: 
//				System.out.println("Rock has been called\n");
//			case SPEEDBUFF: 
//				System.out.println("Speedbuff has been called\n");
//		}
//	}

}