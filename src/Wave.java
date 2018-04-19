import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Wave {
	private int count = 0;
	private int wave = 1;
	private int fontSize = 100;
	private MainApplication program;
	private Score s;
	public static final int max_enemies = 5;
			//set font size
			//set the position
			// after windowWidth shit subtract font size
	
	//gRectangle.getBounds => returns GREctangle
	//getimage.getbounds (intersects) other getimage.getbounds
	public Wave (MainApplication app) {
		GLabel waveLabel = new GLabel("Wave ");
		waveLabel.setFont("Arial-Bold-" + fontSize);
		waveLabel.setLabel("Wave " + wave);
		waveLabel.setLocation(program.WINDOW_WIDTH/2 - fontSize, program.WINDOW_HEIGHT/2 - fontSize);
		app.add(waveLabel);
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
	
	public void newWave() { // update for new waves
		//set delay?
	}
	
	public void incrementWave() {
		wave++;
	}
	
	public void spawn() {
	//enemy to spawn
	// wave 0
		//officially spawn wave 1 to trigger waves
		//or delay it
	}
	
	public void getNextEnemy() {
	// get next enemy (this is what counter is for - randomize it)
		//switch
			// case new enemy (game, #)
	//if the maxSize of array is less than max enemies
		//then add a fish
		//do you want it to spawn on the left or the right? then do rgen
		//new Fish(game, x, rgen())
		//when fish gets eaten remove from array
		
	}
	
	
	public boolean endWave() {
		if(s.getScore() % 50 == 0) {
			//clear screen
			//change sizing??
			//reset counters
			return true;
		}
		else
			return false;
		//wave is over when score = something
		// resets variables enemy size
		//resets counter for when enemies spawn
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
