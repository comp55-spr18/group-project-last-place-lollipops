import java.awt.Color;

// SpeedBuff class ---> can diversify to buffs in general
public class Buff extends Entity{
	// 255- 204- 51
	public Buff(double speed, int size, double x, double y, Color color) { 		
		setSpeed(speed);
		setSize(size);
		setxPosition(x);
		setyPosition(y);
		color = new Color(255, 204, 51);
		setColor(color);
	}
	
	//functions of what speedbuff does
}
