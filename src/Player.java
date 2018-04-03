import java.awt.Color;

//silvana & kevin
public class Player {
	// type Entity allows access to fish
	public Entity p; //player fish p
	//moves player fish
	public Player() {
		p = new Entity(EntityType.FISH, 1, 3, 0, 0, Color.red );
		
	}
	//**Needs a function to determine what key was pressed then passes amount to move.
	public void move(int xPosition, int yPosition)
	{
		p.setxPosition(p.getxPosition()+xPosition);
		p.setyPosition(p.getyPosition() + yPosition);
	}
	//checks if player fish has collided with anything
	public boolean checkCollision() {
		double xWidth = p.getxPosition() + p.getWidth() + 1; // x coordinate & width of fish
		double yHeight = p.getyPosition() + p.getHeight()/2; // y coordinate & height of fish

		//implement pixel-perfect collision detection
		
		return true;
		}

//	}

	public void collision() {
		if(checkCollision()) {
		
		//call function of whatever [type] it collided with  */
		//check player size and coordinates
		
		//did the player collide with anything?
			//if so what?
		} 
		
	}
	
	public int grow(int s) {
		
		return 0;
	}
	
}
