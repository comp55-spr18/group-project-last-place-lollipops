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
			System.out.println("NPE");
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
