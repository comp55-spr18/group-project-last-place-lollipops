
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
			width = 2;
			height = 2;
			size = 1;
			color = "BLUE";
	}
	public Entity(EntityType eType, double speed, int size, double xPos, double yPos, String color) {
		this.eType = eType;
		this.speed = speed;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.size = size;
		this.color = color;
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
	
	
	
}
