import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import acm.util.RandomGenerator;

public class MainApplication extends GraphicsApplication implements ActionListener {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int MS = 10;
	public static final int MAX_ENEMY = 5;

	private MenuPane menu;
	private PausePane pause;
	private GamePane game;
	private SettingsPane settings;
	private InstructionsPane instructions;
	private LeaderboardsPane leaderboards;
	private Fish f;
	private int count;
	private Garbage g;
	//private boolean run = false; // for tick()

	public ArrayList<Fish> fishLtoR = new ArrayList<Fish>();
	public ArrayList<Fish> fishRtoL = new ArrayList<Fish>();
	public boolean volume = true;
	public Timer movement;
	public RandomGenerator rgen;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		g = new Garbage(this, 10);
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

	public void playMenuMusic() {
		if (!volume)
			return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "Race Against The Sunset.mp3");
	}

	public void pauseMenuMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "Race Against The Sunset.mp3");
	}

	public void playGameMusic() {
		if (!volume)
			return;
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("", "Lullatone1.mp3");
	}

	public void pauseGameMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound("", "Lullatone1.mp3");
	}

	public void stopGameMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.stopSound("", "Lullatone1.mp3");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		/*for (Fish fish : fishRtoL ) {
			if (fish.fishImage.getX()==0) {
				fishRtoL.remove(fish);
				remove(fish.fishImage);
			}
		}
		
			for (Fish fish1 : fishLtoR) {
			if (fish1.fishImage.getX()==600) {
			remove(fish1.fishImage);
			fishLtoR.remove(fish1);
			}*/
			
		if((fishLtoR.size() <= MAX_ENEMY) && (fishRtoL.size() <= MAX_ENEMY)) {
			if (count % 200 == 0) {
				int num = rgen.nextInt(0, 2);
				System.out.println("num: " + num + "\n");
				game.addEnemy(num);
			}
		}
		
		moveAllFish();
		g.moveGarbage();
		if (game.playerMove) {
			game.playerMovement();
//			 game.collision();
		}
	}

	public void moveAllFish() {
		for (Fish f : fishLtoR) {
			if (f.fishImage.getX() > WINDOW_WIDTH+50) {
				 f.fishImage.setLocation(0, rgen.nextInt(0, WINDOW_HEIGHT));
			} else {
				f.fishImage.move(2, 0);
			}
		}
		for (Fish f : fishRtoL) {
			if (f.fishImage.getX() < 0-70) {
				 f.fishImage.setLocation(WINDOW_WIDTH, rgen.nextInt(0, WINDOW_HEIGHT));
			} else {
				f.fishImage.move(-2, 0);
			}
		}
	}
	
	public void collision() {
		for (Iterator<Fish> itr = fishLtoR.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			if (game.collisionInteractions(f) ==1 ) {
				itr.remove();
			}
		}
		for (Iterator<Fish> itr = fishRtoL.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			if (game.collisionInteractions(f) ==1 ) {
				itr.remove();
			}
		}
	}
}
