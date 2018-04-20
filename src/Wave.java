import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Wave {
	private int wave = 1;
	private int fontSize = 100;
	private MainApplication program;
	private GLabel waveLabel;
	public static final int MAX_ENEMY = 5;
			//set font size
			//set the position
			// after windowWidth shit subtract font size
	
	//gRectangle.getBounds => returns GREctangle
	//getimage.getbounds (intersects) other getimage.getbounds
	public Wave () {
		waveLabel = new GLabel("Wave ");
		waveLabel.setFont("Arial-Bold-" + fontSize);
		waveLabel.setLabel("Wave " + wave);
		waveLabel.setLocation(program.WINDOW_WIDTH/2 - waveLabel.getWidth()/2, program.WINDOW_HEIGHT/2);
	}
	
	public GLabel getWaveLabel() {
		return waveLabel;
	}
	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getWave() {
		return wave;
	}
	
	public void setWave(int wave) {
		this.wave = wave;
	}
	
	
	public void incrementWave() {
		wave++;
	}
	
	public void newWave() {
		incrementWave();
		//program.add();
		System.out.println("new wave: " + getWaveLabel());
		
	}

	
	//destroy fish when the sprite bounds are out of bounds
		//if x or y < 0 (max width)
		//get rid of the fish from the array and everything about it
		// new fish will be spawn because maxSize < max enemies
	
	//if garbage gets triggered (random num genereator)
	// trigger garbage
	
	
	//check if lose
	
	//** need delay so all fish dont spawn at the same time*** until you hit the max size
	}
