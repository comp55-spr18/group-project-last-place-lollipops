
public class Entity {
	private EntityType eType;
	private double speed;
	private double xPosition;
	private double yPosition;
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
	public void setSize(int size) {
		this.size = size;
	}
	public void setColor(String color) {
		this.color = color;
	}



}
