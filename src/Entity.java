//kevin
import java.awt.*;

import acm.graphics.*;
public abstract class Entity implements Collision {
	private double speed;
	public GObject obj;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	@Override
	public boolean collideWith(Entity o) {
		// TODO Auto-generated method stub
		return ((o.obj.getX() + o.obj.getWidth() > obj.getX() 
				&& o.obj.getX() < obj.getX() + obj.getWidth()) //right and left overlap
				&& (o.obj.getY() + o.obj.getHeight() > obj.getY() 
				&& o.obj.getY() < obj.getY() + obj.getHeight())); //top and bottom overlap
	}
}