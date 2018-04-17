import java.awt.Color;
import acm.graphics.GImage;

public class Player extends Fish { //implements actionListener ??
	private Entity e;
	private double x;
	private double y;
	private double moveX = 0;
	private double moveY = 0;
	private GImage p;
	public Fish f;

	//constructor
	public Player(MainApplication app, int size) { 
		super(app);		
		//setSpeed(speed);
		setSizeCounter(size);
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
		size = f.getSize() + 1;
		return size;
	}

	// checks if player fish has collided with anything
	public boolean checkCollision() {
		// get GImage
		//if player image encounters another image
//		if(player.getImage().getBounds().intersects(enemies.getImage().getBounds())) {
//			return true;
//
//		}
//		Fish foo = player fish location 
//		if (getElementAt(foo == Fish f))
//			return true;
		return false;
	}

	public void collision() {
		if (checkCollision()) {
//			collidedWith(getSize());
			// call function of whatever [type] it collided with
			// check player size and coordinates

			// did the player collide with anything?
			// if so what?
		}

	}
}
