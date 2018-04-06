import java.awt.Color;
import acm.graphics.GImage;

//silvana & kevin
public class Player extends Fish { //implements actionListener ??
	private Entity e;
	private Player player;
	//constructor
	public Player(GImage p, double speed, int size, double x, double y, Color color) { 
		color = Color.yellow; // temporary
		
		setSpeed(speed);
		setSize(size);
//		setxPosition(x);
//		setyPosition(y);
		setColor(color);
	}
	
	//functions
	// move() is not needed. Uses Keylistener function in GamePane
	
	public int grow(int s) {
		s = getSize();
		s += 2 ; // needs setSize() ???
		return s;
	}
	
	// checks if player fish has collided with anything
		public boolean checkCollision() {
			// get GImage
			//if player image encounters another image
			if(player.getImage().getBounds().intersects(enemies.getImage().getBounds())) {
				return true;
	
			}
			return false;
		}

		public void collision() {
			if (checkCollision()) {
				collidedWith(getSize());
				// call function of whatever [type] it collided with
				// check player size and coordinates

				// did the player collide with anything?
				// if so what?
			}

		}

		// should this be in Player or Entity?
		public void collidedWith(int s) { // object entity e, size s

			switch (e) { // ***print statements are only for testing***
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

		// 6 different functions named the same but they all do the different things
	
}
