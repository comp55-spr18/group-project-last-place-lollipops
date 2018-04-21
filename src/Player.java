import java.awt.Color;
import acm.graphics.GImage;

public class Player extends Fish { 
	private double scale = 0.7;
	

	public double getScale() {
		return scale;
	}
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

	public void grow() {
		scale+=.2;
		if (RtL) {
			img.setImage("PlainOldFish.png");
		}else {
			img.setImage("PlainOldFishFlipped.png");
		}
		img.setSize(90,90);
		this.img.scale(scale);
		setSize(getSize() + 2);
		System.out.println("growing up!\n" + getSize());
		
	}
	public boolean getRTL() {
		return RtL;
	}
	
	public void setRTL(boolean bool) {
		RtL = bool;
	}
}
