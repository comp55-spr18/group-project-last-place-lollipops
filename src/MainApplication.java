import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.graphics.GRectangle;
import acm.util.RandomGenerator;

public class MainApplication extends GraphicsApplication implements ActionListener {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int MS = 10;
	public static final int MAX_ENEMY = 5; //gets doubled because of two arrays

	private MenuPane menu;
	private PausePane pause;
	private SettingsPane settings;
	private InstructionsPane instructions;
	private LeaderboardsPane leaderboards;
	private LosePane lose;
	private Wave wave;
	private Garbage garbage;
	private int nextScore = 50;

	public int count = 0;
	public int spawnTypes = 0;

	public boolean volume = true;
	public Timer movement;
	public RandomGenerator rgen;
	public GamePane game;


	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}



	public void updateLeaderboards() {
		leaderboards = new LeaderboardsPane(this);
	}
	public LosePane getLosePane() {
		return lose;
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
		lose = new LosePane(this);
		wave = new Wave();
		switchToMenu();
	}

	public void switchToMenu() {
		switchToScreen(menu);
		playMenuMusic();
	}

	public void switchToGame() {
		switchToScreen(game);
		pauseMenuMusic();
		playGameMusic();
	}

	public void switchToNewGame() {
		game = new GamePane(this);
		wave = new Wave();
		count = 0;
		spawnTypes = 0;
		nextScore = 50;
		try {
			remove(garbage.img);
			garbage = null;
		}
		catch(NullPointerException e) {
			System.out.println("garbage is already null!");
		}
		switchToScreen(game);
		pauseMenuMusic();
		playGameMusic();
		add(wave.getWaveLabel());
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
	public void switchToLose() {
		switchToScreen(lose);
		try {
			remove(garbage.img);
			garbage = null;
		}
		catch(NullPointerException e) {
			System.out.println("garbage is already null!");
		}
		movement.stop();
	}

	public void playMenuMusic() {
		if (!volume)
			return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "Lullatone1.mp3");
	}

	public void pauseMenuMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "Lullatone1.mp3");
	}

	public void playLoseMusic() {
		if (!volume)
			return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "sadsong.mp3");
	}
	
	public void pauseLoseMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "sadsong.mp3");
	}
	public void stopLoseMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.stopSound("", "sadsong.mp3");
	}
	public void playGameMusic() {
		if (!volume)
			return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "Race Against The Sunset.mp3");
	}

	public void pauseGameMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "Race Against The Sunset.mp3");
	}

	public void stopGameMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.stopSound("", "Race Against The Sunset.mp3");
	}

	public void moveGarbage() {
		garbage.move(1, 1);
		//		if(garbage.img.getX()>WINDOW_WIDTH) {
		//			garbage = null;
		//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (game.playerMove) { // moves the player
			game.playerMovement();
		}

		if(count == 100) { // after 1000 ms, take off Wave Label
			System.out.println("removing wave label!");
			remove(wave.getWaveLabel());
		}

		count++;
		if((game.fishLtoR.size() + game.fishRtoL.size() <= MAX_ENEMY)) {
			if (count % 100 == 0 && count > 0) {
				int num = rgen.nextInt(0, spawnTypes);
				//System.out.println("num: " + num + "\n");
				game.addEnemy(num);
			}
		}
		game.moveAllFish();
		collision();

		try {
			moveGarbage();
			if(garbage.img.getX() > MainApplication.WINDOW_WIDTH) {
				remove(garbage.img);
				garbage=null;
			}
		}catch(NullPointerException ex) {
			
		}

		int randomGarbage = rgen.nextInt(0, 5000);
		if (garbage == null && randomGarbage <= 7) { // makes garbage spawn at a random time during a wave
			garbage = new Garbage();
			System.out.println("I made garbage!");
			add(garbage.getGarbageImage());
		}

		// Every 50 pts, initiate new Wave
		if(game.s.getScore() % 50 == 0 && game.s.getScore() >= nextScore) { 
			wave.incrementWave();
			add(wave.getWaveLabel());
			game.deleteAllFish();
			game.getPlayer().grow();
			nextScore += 50;
			spawnTypes += 1;
			count = 0;
		}
	}

	public void collision() {
		int interactionOutcome = 0;
		for (Iterator<Fish> itr = game.fishLtoR.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			interactionOutcome = game.collisionInteractions(f);
			switch(interactionOutcome) {
			case 0: {
				itr.remove();
				break;
			}
			case 1: {
				lose = new LosePane(this);
				switchToLose();
				break;
			}
			default: {//2 doesn't do anything

				break;
			}
			}

		}
		for (Iterator<Fish> itr = game.fishRtoL.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			interactionOutcome = game.collisionInteractions(f);
			switch(interactionOutcome) {
			case 0: {
				itr.remove();
				break;
			}
			case 1: {
				lose = new LosePane(this);
				switchToLose();
				break;
			}
			default: {//2 doesn't do anything

				break;
			}
			}
		}
		switch(game.collisionInteractions(garbage)) {
		case 0: { //you should never eat the garbage
			//this should never happen
			break;
		}
		case 1: {
			lose = new LosePane(this);
			switchToLose();
			pauseGameMusic();
			playLoseMusic();
			break;
		}
		default: {//2 doesn't do anything
			break;
		}
		}
	}

	public GamePane getGame() {
		return game;
	}
}

