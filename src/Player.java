import java.awt.Color;
import acm.graphics.GImage;

public class Player extends Fish { 

	public Player(MainApplication app, int size) { 
		super(app);		
		setSize(size);
	}
	public boolean isAtTop() {
		if(img.getY()>0) {
			return false;
		}
		return true;
	}
	
	public boolean isAtBottom() {
		if(img.getY()< MainApplication.WINDOW_HEIGHT-img.getHeight()) {
			return false;
		}
		return true;
	}
	public boolean isAtLeft() {
		if(img.getX()>0) {
			return false;
		}
		return true;
	}
	
	public boolean isAtRight() {
		if(img.getX()< MainApplication.WINDOW_WIDTH-img.getWidth()) {
			return false;
		}
		return true;
	}

	public int grow(int size) {
		this.img.scale(1.25);
		size = getSize() + 2;
		System.out.println("setting size: " + size + "\n");
		return size;
	}
	public boolean getRTL() {
		return RtL;
	}
	
	public void setRTL(boolean bool) {
		RtL = bool;
	}
}
