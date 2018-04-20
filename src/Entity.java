//kevin
import java.awt.*;

import acm.graphics.*;
public abstract class Entity {
	public GImage img;
	public boolean collideWith(Entity o) {
		// TODO Auto-generated method stub
		try {
			return ((o.img.getX() + o.img.getWidth() > img.getX() 
				&& o.img.getX() < img.getX() + img.getWidth()) //right and left overlap
				&& (o.img.getY() + o.img.getHeight() > img.getY() 
				&& o.img.getY() < img.getY() + img.getHeight())); //top and bottom overlap
		}catch(NullPointerException e) {
			return false;
		}
	}
}