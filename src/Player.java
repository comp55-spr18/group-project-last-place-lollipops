
public class Player {
	// type Entity allows access to fish
	private Entity p; //player fish p
	//moves player fish

	
	public void move(int xPosition, int yPosition)
	{
		p.setxPosition(p.getxPosition()+xPosition);
		p.setyPosition(p.getyPosition() + yPosition);
	}
	//checks if player fish has collided with anything
	public boolean checkCollision() {
		double xWidth = p.getxPosition() + p.getWidth() + 1; // x coordinate & width of fish
		double yHeight = p.getyPosition() + p.getHeight()/2; // y coordinate & height of fish

		//if(getElementAt(xWidth, yHeight) != null) { // if fish ran into something, return true
			return true;
		}
		
	//	return false; // else return false
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
