public class Player {
	// type Entity allows access to fish
	private Entity p; //player fish p
	
	//moves player fish
	public void move() {
		
	}
	
	//checks if player fish has collided with anything
	public boolean collision() {
		double xWidth = p.getxPosition() + p.getWidth() + 1; // x coordinate & width of fish
		double yHeight = p.getyPosition() + p.getHeight()/2; // y coordinate & height of fish

		if(getElementAt(xWidth, yHeight) != null) { // if fish ran into something, return true
			return true;
		}
		
		return false; // else return false
	
	}

	public void collided() {
		//call function of whatever [type] it collided with  */
		boolean collided = false;
		//check player size and coordinates
		
		//did the player collide with anything?
		if(collision()) {
			//if so what?
		} 
		
	}
	
}
