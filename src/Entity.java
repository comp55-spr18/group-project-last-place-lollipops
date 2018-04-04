//kevin
import java.awt.*;

import acm.graphics.GImage;
public class Entity {
	private double speed;
	private double xPosition;
	private double yPosition;
	private Color color;
	private GImage image; // for sprites ("image name.png", x, y)

	//private double width; // *** instead of doing collision like in DodgeBall.java
	//private double height; // maybe get GImage?? ***

	public double getSpeed() {
		return speed;
	}
	public double getxPosition() {
		return xPosition;
	}
	public double getyPosition() {
		return yPosition;
	}
	
	public Color getColor() {
		return color;
	}
	/*	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	} */

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}
	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	/*	public void setWidth() {
		this.width = width;
	}
	public void setHeight() {
		this.height = height;
	}*/

	public void collidedWith(EntityType e, int s) { // object entity e, size s
		switch(e) { // ***print statements are only for testing***
			case KELP: 
				System.out.println("Kelp has been called\n");
			case HOOK: 
				System.out.println("Hook has been called\n");
			case FISH: 
				System.out.println("Fish has been called\n");
			case ROCK: 
				System.out.println("Rock has been called\n");
			case SPEEDBUFF: 
				System.out.println("Speedbuff has been called\n");
		}
	}

}