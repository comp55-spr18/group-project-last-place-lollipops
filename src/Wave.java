import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Wave {
	private int wave = 1;
	private int fontSize = 100;
	private GLabel waveLabel;
	public static final int MAX_ENEMY = 5;
	
	public Wave () {
		waveLabel = new GLabel("Wave ");
		waveLabel.setFont("Arial-Bold-" + fontSize);
		waveLabel.setLabel("Wave " + wave);
		waveLabel.setLocation(MainApplication.WINDOW_WIDTH/2 - waveLabel.getWidth()/2, MainApplication.WINDOW_HEIGHT/2);
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
		waveLabel.setLabel("Wave " + wave);
		System.out.println("new wave: " + getWaveLabel());
	}
	


}
