import java.awt.Color;

//silvana & kevin
public class Player extends Fish { //implements actionListener ???
	//constructor
	public Fish f;
	
	public Player(double speed, int size, double x, double y, Color color) { 
		f = new Fish();
		f.color = color; 
		
		setSpeed(speed);
		setSize(size);
		setColor(color);
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
