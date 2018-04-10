
//kyla
import java.awt.event.MouseEvent;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.GImage;
import acm.graphics.*;
import java.util.*;

public class GamePane extends GraphicsPane {
	private MainApplication program;
	private GButton pause;
	private Fish player;
	private Score s;
	private GImage gameBackground;
	private GParagraph title;

	private GImage rock;
	private final Set<Integer> pressed = new TreeSet<Integer>();


	private ArrayList<Fish> fishLtoR;
	private ArrayList<Fish> fishRtoL;

	public boolean playerMove;
	public int keyPress;

	public GamePane(MainApplication app) {
		this.program = app;

		fishLtoR = new ArrayList<Fish>();
		fishRtoL = new ArrayList<Fish>();

		title = new GParagraph("Something Smells Fishy", 50, 30);
		title.setFont("Forte-30");
		title.setColor(Color.pink);

		s = new Score();
		s.setScoreTxt(new GLabel(Integer.toString(s.getScore()),50,60));
		
		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());

		pause.setFillColor(Color.RED);

		gameBackground = new GImage("GamePane.jpg", 0, 0);
		gameBackground.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		player = new Fish();
		player.setFish(new GImage("PlainOldFish.png",program.WINDOW_WIDTH/2, program.WINDOW_HEIGHT/2));

		for (int i = 0; i < program.MAX_ENEMY; i++) {
			makeFish();
		}
		System.out.println(fishLtoR.size() +", "+fishRtoL.size());
	}


	public int collisionInteractions(Entity o) {
		/* 0 = you lose
		 * 1 = collided with a fish but u ate it
		 * 2 = do nothing (at the momemnt)
		 * 
		 */
		if (player.collideWith(o)) {
			if (o instanceof Fish) {
				if (((Fish) o).getSizeCounter() > player.getSizeCounter()) {
					System.out.println("you lose!");
					program.remove(player.getFish());
					return 0; 
				}
				else {
					program.remove(((Fish) o).getFish());
					s.increment();
					return 1; 
					
				}
			}
			else if (o instanceof Kelp) {
				return 2; 
			}
			else if (o instanceof Rock) {
				//are we making falling rocks? or non-lethal that do nothing?
				return 2;
			}
			else if (o instanceof Hook) {
				return 2;
			}
			else if (o instanceof Buff) {
				// what do these do?????????
				return 2;
			}
		}
		return 2;
	}
	public void collision() {
		for (Iterator<Fish> itr = fishLtoR.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			if (collisionInteractions(f) ==1 ) {
				itr.remove();
			}
		}
		for (Iterator<Fish> itr = fishRtoL.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			if (collisionInteractions(f) ==1 ) {
				itr.remove();
			}
		}
	}
	

	public Fish makeFish() {
		Fish f = new Fish();
		int random = program.rgen.nextInt(0, 1);
		if (random == 0) {
			f.setFish(new GImage("SmallFryFlipped.png", 0,program.rgen.nextInt(0, program.WINDOW_HEIGHT)));
			f.getFish().setLocation(f.getFish().getX() - f.getFish().getWidth(), f.getFish().getY());
			fishLtoR.add(f);
			return f;
		}
		else {
			f.setFish(new GImage("SmallFry.png", program.WINDOW_WIDTH,program.rgen.nextInt(0, program.WINDOW_HEIGHT)));
			fishRtoL.add(f);
			return f;
		}
	}

	public void addAllFish() {

		for (Fish f: fishLtoR) {
			program.add(f.getFish());
		}
		for (Fish f: fishRtoL) {
			program.add(f.getFish());
		}
	}

	public void removeAllFish() {
		for (Fish f: fishLtoR) {
			program.remove(f.getFish());

		}
		for (Fish f: fishRtoL) {
			program.remove(f.getFish());
		}
	}

	public void moveAllFish() {
		for (Fish f: fishLtoR) {
			if (f.getFish().getX() > program.WINDOW_WIDTH) {
				f.getFish().setLocation(0 - f.getFish().getWidth(), f.getFish().getY());
			}
			else {
				f.getFish().move(2, 0);
			}
		}
		for (Fish f: fishRtoL) {
			if (f.getFish().getX() < 0 - f.getFish().getWidth()) {
				f.getFish().setLocation(program.WINDOW_WIDTH, f.getFish().getY());
			}
			else {
				f.getFish().move(-2, 0);
			}
		}
	}

	@Override
	public void showContents() {
		program.add(gameBackground);
		program.add(pause);
		program.add(title);
		program.add(s.getScoreTxt());
		addAllFish();
		program.add(player.getFish());
		program.movement.start();
	}


	@Override
	public void hideContents() {
		program.remove(gameBackground);
		program.remove(pause);
		program.remove(title);
		program.remove(s.getScoreTxt());
		removeAllFish();
		program.remove(player.getFish());
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
		System.out.println("pressed size: " + pressed.size());
		if (pressed.size() > 1) { // if two keys are pressed, move diagonally
			Integer[] arr = pressed.toArray(new Integer[] {}); //save multiple key pressed into an array
			if ((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) ||
			    (arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_RIGHT)){
				player.getFish().setImage("PlainOldFishFlipped.png");
				player.getFish().move(2, -2);
			}
			else if((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_LEFT ) || 
					(arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_LEFT )) {
				player.getFish().setImage("PlainOldFish.png");
				player.getFish().move(-2, -2);
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_RIGHT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_RIGHT)) {
				player.getFish().setImage("PlainOldFishFlipped.png");
				player.getFish().move(2, 2);
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_LEFT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_LEFT)) {
				player.getFish().setImage("PlainOldFish.png");
				player.getFish().move(-2, 2);
			}
		}

		else {
			switch (keyPress) {
			case KeyEvent.VK_UP: {
				player.getFish().move(0, -2);
				break;
			}
			case KeyEvent.VK_DOWN: {
				player.getFish().move(0, 2);
				break;
			}
			case KeyEvent.VK_LEFT: {
				player.getFish().setImage("PlainOldFish.png");
				player.getFish().move(-2, 0);
				break;
			}
			case KeyEvent.VK_RIGHT: {
				player.getFish().setImage("PlainOldFishFlipped.png");
				player.getFish().move(2, 0);
				break;
			}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.getFish().sendToFront();
		gameBackground.sendToBack();
		keyPress = e.getKeyCode();
		playerMove = true;
	}

	public void keyReleased(KeyEvent e) {
		pressed.remove(Integer.valueOf(e.getKeyCode()));
		playerMove = false;
	}

}
