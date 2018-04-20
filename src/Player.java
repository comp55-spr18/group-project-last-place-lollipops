import java.awt.Color;
import acm.graphics.GImage;

public class Player extends Fish { //implements actionListener ??

	public Player(MainApplication app, int size) { 
		super(app);		
		setSize(size);
	}
	public boolean isAtTop() {
		if(fishImage.getY()>0) {
			return false;
		}
		return true;
	}
	
	public boolean isAtBottom() {
		if(fishImage.getY()< MainApplication.WINDOW_HEIGHT-fishImage.getHeight()) {
			return false;
		}
		return true;
	}
	public boolean isAtLeft() {
		if(fishImage.getX()>0) {
			return false;
		}
		return true;
	}
	
	public boolean isAtRight() {
		if(fishImage.getX()< MainApplication.WINDOW_WIDTH-fishImage.getWidth()) {
			return false;
		}
		return true;
	}

	public int grow(int size) {
		this.fishImage.scale(1.25);
		size = getSize() + 1;
		return size;
	}
	@Override
	public boolean collideWith(Entity o) {
		// TODO Auto-generated method stub
		try {
			return ((o.obj.getX() + o.obj.getWidth() > fishImage.getX() 
					&& o.obj.getX() < fishImage.getX() + fishImage.getWidth()) //right and left overlap
					&& (o.obj.getY() + o.obj.getHeight() > fishImage.getY() 
					&& o.obj.getY() < fishImage.getY() + fishImage.getHeight())); //top and bottom overlap
		}catch(NullPointerException e) {
			System.out.println("NPE!");
			return false;
		}
	}
	public boolean getRTL() {
		return RtL;
	}
	
	public void setRTL(boolean boo) {
		RtL = boo;
	}
}
