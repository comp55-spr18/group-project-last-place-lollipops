//kevin
import java.awt.*;
public class Entity {
	private EntityType eType;
	private double speed;
	private double xPosition;
	private double yPosition;
	private double width;
	private double height;
	private int size;
	private Color color;

	public Entity() {
		eType = EntityType.FISH;
		speed = 0.0;
		xPosition = 0;
		yPosition = 0;
		size = 1;
		color = Color.red;
	}


	public Entity(EntityType eType, double speed, int size, double xPos, double yPos, Color color) {
		this.eType = eType;

		switch(eType) {
		case FISH:{
			this.color = color;
			this.speed = speed;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
			break;
		}
		case ROCK:{//102- 51- 0
			this.color = new Color(102, 51, 0);
			this.speed = 0;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
			break;
		}
		case KELP:{
			this.color = Color.green;
			this.speed = 0;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
			break;
		}
		case HOOK:{
			this.color = Color.gray;
			this.speed = speed;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
			break;
		}
		case SPEEDBUFF:{//255-204- 51
			this.color = new Color(255,204,51);
			this.speed = speed;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
			break;
		}
		}
	}
	public EntityType geteType() {
		return eType;
	}
	public double getSpeed() {
		return speed;
	}
	public double getxPosition() {
		return xPosition;
	}
	public double getyPosition() {
		return yPosition;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public int getSize() {
		return size;
	}
	public Color getColor() {
		return color;
	}
	public void seteType(EntityType eType) {
		this.eType = eType;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}
	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}
	public void setWidth() {
		this.width = width;
	}
	public void setHeight() {
		this.height = height;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public void collidedWith(EntityType e, int s) { // object entity e, size s
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
	}

}