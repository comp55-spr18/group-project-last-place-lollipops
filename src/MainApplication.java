import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import acm.util.RandomGenerator;

public class MainApplication extends GraphicsApplication implements ActionListener {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "Lullatone1.mp3", "somethinlikethis.mp3" };

	public static final int MS = 10;
	public static final int MAX_ENEMY = 4;
	
	private MenuPane menu;
	private PausePane pause;
	private GamePane game;
	private SettingsPane settings;
	private InstructionsPane instructions;
	private LeaderboardsPane leaderboards;
	private Fish f;
	public ArrayList<Fish> fishLtoR = new ArrayList<Fish>();
	public ArrayList<Fish> fishRtoL = new ArrayList<Fish>();
	private int count;
	public boolean volume = true;
	
	public Timer movement;
	public RandomGenerator rgen;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		rgen = RandomGenerator.getInstance();
		movement = new Timer(MS, this);
		game = new GamePane(this);
		pause = new PausePane(this);
		settings = new SettingsPane(this);
		instructions = new InstructionsPane(this);
		leaderboards = new LeaderboardsPane(this);

		menu = new MenuPane(this);
		switchToMenu();
	}

	public void switchToMenu() {
		//playRandomSound();
		count++;
		switchToScreen(menu);
		playMenuMusic();
	}

	public void switchToSome() {
		//playRandomSound();
		pauseMenuMusic();
		playGameMusic();
		
	}
	public void switchToGame() {
		switchToScreen(game);
		pauseMenuMusic();
		playGameMusic();
	}
	
	public void switchToSettings() {
		switchToScreen(settings);
	}
	
	public void switchToInstructions() {
		switchToScreen(instructions);
	}
	
	public void switchToLeaderboards() {
		switchToScreen(leaderboards);
	}
	public void switchToPause() {
		switchToScreen(pause);
		movement.stop();
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public void playMenuMusic() {
		if (!volume) return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "lobby.mp3");
	}
	public void pauseMenuMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "lobby.mp3");
	}
	public void playGameMusic() {
		if (!volume) return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "gameMusic.mp3");
	}
	public void pauseGameMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "gameMusic.mp3");
	}
	//main app
	public void moveAllFish() {
		for (Fish f : fishLtoR) {
			if (f.fishImage.getX() > WINDOW_WIDTH) {
				f.fishImage.setLocation(0, f.fishImage.getY());
			} else {
				f.fishImage.move(2, 0);
			}
		}
		for (Fish f : fishRtoL) {
			if (f.fishImage.getX() < 0) {
				f.fishImage.setLocation(WINDOW_WIDTH, f.fishImage.getY());
			} else {
				f.fishImage.move(-2, 0);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		moveAllFish();
		
		if (game.playerMove) {
			game.playerMovement();
		}
	}
}
