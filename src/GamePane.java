
//kyla
import java.awt.event.MouseEvent;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.GImage;
import acm.graphics.GObject;
import java.util.*;

public class GamePane extends GraphicsPane {
	private MainApplication program;

	private GButton pause;
	private GImage player;
	private GImage gameBackground;
	private GParagraph title;
	private GImage rock;
	private final Set<Integer> pressed = new TreeSet<Integer>();
	private Fish f;
	
	public boolean playerMove;
	public int keyPress;

	public GamePane(MainApplication app) {
		this.program = app;

		title = new GParagraph("Something Smells Fishy", 50, 30);
		title.setFont("Forte-30");
		title.setColor(Color.pink);

		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());

		pause.setFillColor(Color.RED);

		gameBackground = new GImage("GamePane.jpg", 0, 0);
		gameBackground.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		player = new GImage("PlainOldFish.png", program.WINDOW_WIDTH / 2, program.WINDOW_HEIGHT / 2);
		
		for (int i = 0; i < program.MAX_ENEMY; i++) {
			f = new Fish(app);
		} 
		 System.out.println(program.fishLtoR.size() + ", " + program.fishRtoL.size());

	}

	public void removeAllFish() {
		for (Fish f : program.fishLtoR) {
			program.fishLtoR.remove(f.fishImage);
		}
		for (Fish f : program.fishRtoL) {
			program.fishRtoL.remove(f.fishImage);
		}
	}
	public void addAllFish() {
		System.out.println("Add all Fish\n");
		for (Fish f : program.fishLtoR) {
				System.out.println("Enter for loop LtoR\n");
				System.out.println("Set size LtoR\n");
			program.add(f.fishImage);
				System.out.println("add LtoR fish\n");
		}
		for (Fish f : program.fishRtoL) {
				System.out.println("Enter for loop RtoL\n");
				System.out.println("Set size RtoL\n");
			program.add(f.fishImage);
				System.out.println("add LtoR fish\n");
		}
	}
	@Override
	public void showContents() {
		program.add(gameBackground);
		program.add(pause);
		program.add(title);
		addAllFish();
		program.add(player);
		program.movement.start();
		
	}

	@Override
	public void hideContents() {
		program.remove(gameBackground);
		program.remove(pause);
		program.remove(title);
		removeAllFish();
		program.remove(player);
		program.movement.stop();
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == pause) {
			program.switchToPause();
		}
	}
	
	public void playerMovement() {
		pressed.add(keyPress); 
		if (pressed.size() > 1) { // if two keys are pressed, move diagonally
			Integer[] arr = pressed.toArray(new Integer[] {}); //save multiple key pressed into an array
			if ((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) ||
			    (arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_RIGHT)){
				player.setImage("PlainOldFishFlipped.png");
				player.move(2, -2);
			}
			else if((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_LEFT ) || 
					(arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_LEFT )) {
				player.setImage("PlainOldFish.png");
				player.move(-2, -2);
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_RIGHT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_RIGHT)) {
				player.setImage("PlainOldFishFlipped.png");
				player.move(2, 2);
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_LEFT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_LEFT)) {
				player.setImage("PlainOldFish.png");
				player.move(-2, 2);
			}
		}
		
		else { // otherwise, move in one direction
			switch (keyPress) {
			case KeyEvent.VK_UP: {
				player.move(0, -2);
				break;
			}
			case KeyEvent.VK_DOWN: {
				player.move(0, 2);
				break;
			}
			case KeyEvent.VK_LEFT: {
				player.setImage("PlainOldFish.png");
				player.move(-2, 0);
				break;
			}
			case KeyEvent.VK_RIGHT: {
				player.setImage("PlainOldFishFlipped.png");
				player.move(2, 0);
				break;
			}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.sendToFront();
		gameBackground.sendToBack();
		keyPress = e.getKeyCode();
		playerMove = true;
	}

	public void keyReleased(KeyEvent e) {
		pressed.remove(Integer.valueOf(e.getKeyCode()));
		playerMove = false;
	}

}
