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
	public static final int MS = 1;
	public static final int MAX_ENEMY = 4; //gets doubled because of two arrays

	private MenuPane menu;
	private PausePane pause;
	private SettingsPane settings;
	private InstructionsPane instructions;
	private LeaderboardsPane leaderboards;
	private Wave wave;
	private LosePane lose;
	private int count;



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
		switchToMenu();
	}


	/*private synchronized void start() {
	 * if(running)
	 * 	return;
	 * 
	 * running = true;
	 * thread = new Thread(this);
	 * thread.start();
	 */
	/*	
	public void ticking() { // allows for smoother player movement
		long time = System.nanoTime();
		double numTicks = 60;
		double ns = 1000000000 / numTicks;
		double update = 0; // calculates the time passed (to catch up)
		int u = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while(run) {
			long now = System.nanoTime();
			update += (time - now) / ns;
			time = now;
			if(update >= 1 ) {
				tick();
				update--;
			}
		}
	}
	 */

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
	public void switchToLose() {
		switchToScreen(lose);
		pauseGameMusic();
		playGameMusic();
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
	//hi

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
		audio.stopSound("", "Lullatone1.mp3");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		//System.out.println(fishLtoR.size() + ", " + fishRtoL.size());
	}

	//	public void run(){
	//		t = new Timer(1000, this);
	//		t.setInitialDelay(3000);
	//		t.start();
	//		
	//	}

	public void update() {
		count++;
		if((game.fishLtoR.size() + game.fishRtoL.size() <= MAX_ENEMY)) {
			if (count % 200 == 0 && count > 0) {
				int num = rgen.nextInt(0, 2);
				//				System.out.println("num: " + num + "\n");
				game.addEnemy(num);
			}
		}
		moveAllFish();
		game.garbage.moveGarbage();
		if (game.playerMove) {
			game.playerMovement();
		}
		collision();
	}

	public void moveAllFish() {
		for (Fish f : game.fishLtoR) {
			if (f.fishImage.getX() > WINDOW_WIDTH + 50) {
				f.fishImage.setLocation(0, rgen.nextInt(0, WINDOW_HEIGHT));
			} else {
				f.fishImage.move(.4, 0);
			}
		}
		for (Fish f : game.fishRtoL) {
			if (f.fishImage.getX() < 0-100) {
				f.fishImage.setLocation(WINDOW_WIDTH, rgen.nextInt(0, WINDOW_HEIGHT));
			} else {
				f.fishImage.move(-.4, 0);
			}
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
	}

	public GamePane getGame() {
		return game;
	}
}

