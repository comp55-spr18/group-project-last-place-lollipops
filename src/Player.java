import java.awt.Color;

//silvana & kevin
public class Player extends Fish { //implements actionListener ???
	//constructor
	public Player(double speed, int size, double x, double y, Color color) { 
		color = Color.blue; // temporary
		
		setSpeed(speed);
		setSize(size);
//		setxPosition(x);
//		setyPosition(y);
		setColor(color);
	}
	
	//functions
	//*** Needs a function to determine what key was pressed then passes amount to move. ***
	public void move(int xPosition, int yPosition)
	{
//		setxPosition(getxPosition()+ xPosition);
//		setyPosition(getyPosition() + yPosition);
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
	//should this be in Player or Entity?
/*	public void collidedWith(EntityType e, int s) { // object entity e, size s
		switch(e) { // ***print statements are only for testing***
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
	}*/
	
	public int grow(int s) {
		s = getSize();
		s += 2 ; // needs setSize() ???
		return s;
	}
	
}
