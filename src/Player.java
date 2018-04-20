import java.awt.Color;
import acm.graphics.GImage;

public class Player extends Fish { //implements actionListener ??
	private double x;
	private double y;
	private double moveX = 0;
	private double moveY = 0;
	public Player(MainApplication app, int size) { 
		super(app);		
		setSize(size);
	}
	public void tick() { // allows smoother player movement
		x += moveX;
		y += moveY;
	}

	public void setMoveX(double moveX) {
		this.moveX = moveX;
	}

	public void setMoveY(double moveY) {
		this.moveY = moveY;
	}

	public int grow(int size) {
		this.img.scale(1.25);
		size = getSize() + 1;
		return size;
	}
	public boolean getRTL() {
		return RtL;
	}
	
	public void setRTL(boolean bool) {
		RtL = bool;
	}
}
