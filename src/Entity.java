
public class Entity {
	private EntityType eType;
	private double speed;
	private double xPosition;
	private double yPosition;
	private double width;
	private double height;
	private int size;
	private String color;

	public Entity() {
		eType = EntityType.FISH;
		speed = 0.0;
		xPosition = 0;
		yPosition = 0;
		size = 1;
		color = "RED";
	}


	public Entity(EntityType eType, double speed, int size, double xPos, double yPos, String color) {
		this.eType = eType;

		switch(eType) {
		case FISH:{
			this.color = color;
			this.speed = speed;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;

		}
		case ROCK:{
			this.color = "BROWN";
			this.speed = 0;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
		}
		case KELP:{
			this.color = "GREEN";
			this.speed = 0;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
		}
		case HOOK:{
			this.color = "GREY";
			this.speed = speed;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
		}
		case SPEEDBUFF:{
			this.color = "GOLD";
			this.speed = speed;
			this.xPosition = xPos;
			this.yPosition = yPos;
			this.size = size;
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
	public String getColor() {
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
	public void setColor(String color) {
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