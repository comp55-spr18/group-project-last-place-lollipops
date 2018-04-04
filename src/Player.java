import java.awt.Color;

//silvana & kevin
public class Player extends Fish { //implements actionListener ???
	//constructor
	public Player(double speed, int size, double x, double y, Color color) { 
		color = Color.blue; // temporary
		
		setSpeed(speed);
		setSize(size);
		setxPosition(x);
		setyPosition(y);
		setColor(color);
	}
	
	//functions
	//**Needs a function to determine what key was pressed then passes amount to move.
	public void move(int xPosition, int yPosition)
	{
		setxPosition(getxPosition()+ xPosition);
		setyPosition(getyPosition() + yPosition);
	}
	//checks if player fish has collided with anything
	public boolean checkCollision() {
		//get GImage
	
		return false;
	}
	
	public void collision() {
		if(checkCollision()) {
		
		//call function of whatever [type] it collided with 
		//check player size and coordinates
		
		//did the player collide with anything?
			//if so what?
		} 
		
	}
	
	public int grow(int s) {
		
		return 0;
	}
	
}
