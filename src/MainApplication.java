import java.awt.*;

import acm.graphics.*;
import acm.program.*;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private final String[] SOUND_FILES = {"r2d2.mp3", "somethinlikethis.mp3"};
	
	private SomePane somePane;
	private MenuPane menu;
	private int count = 0;
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		System.out.println("Hello, world!");
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		switchToMenu();
	}
	
	public void switchToMenu() {
		playRandomSound();
		count++;
		switchToScreen(menu);
	}
	
	public void switchToSome() {
		playRandomSound();
		switchToScreen(somePane);
	}
	
	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
}
