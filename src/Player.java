import java.awt.Color;
import acm.graphics.GImage;

public class Player extends Fish { //implements actionListener ??
	private Entity e;
	private Player player;
	public Fish f;

	//constructor
	public Player(MainApplication app, double speed, int size) { 
		super(app);		
		setSpeed(speed);
		setSizeCounter(size);
	}
	
	public int grow(int s) {

		return 0;
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
