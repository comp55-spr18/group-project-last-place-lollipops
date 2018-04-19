
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
	private GImage gameBackground;
	private GButton pause;
	private GParagraph title;
	private final Set<Integer> pressed = new TreeSet<Integer>();
	private Player player;

	public boolean playerMove;
	public int keyPress;
	double moveX = 0;
	double moveY = 0;
	
	public Garbage garbage;
	public Score s;
	public ArrayList<Fish> fishLtoR = new ArrayList<Fish>();
	public ArrayList<Fish> fishRtoL = new ArrayList<Fish>();

	public GamePane(MainApplication app) {
		this.program = app;
		player = new Player(app, 2); // size 2
		garbage = new Garbage(app);
		title = new GParagraph("Something Smells Fishy", 50, 30);
		title.setFont("Forte-30");
		title.setColor(Color.pink);
		s = new Score();
		s.setScoreTxt(new GLabel(Integer.toString(s.getScore()),50,60));
		s.getLabel().setFont("Forte-30");
		s.getLabel().setColor(Color.pink);
		//s.increment();
		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());
		pause.setFillColor(Color.RED);

		gameBackground = new GImage("GamePane.jpg", 0, 0);
		gameBackground.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);

		garbage = new Garbage(app);

	}

	public Score getScore() {
		return s;
	}

	public int collisionInteractions(Entity o) {
		//0 = you ate the fish
		//1 = you lost
		//2 = nothing happened

		if (player.collideWith(o)) {
			if (o instanceof Fish) {
				if (((Fish) o).getSize() > player.getSize()) {
					System.out.println("you lose! because of bigger fish");
					program.remove(player.getFish());
					return 1; 
				}
				else {
					program.remove(((Fish) o).getFish());
					s.increment();
					return 0; 
				}
			}
			else if (o instanceof Garbage) {
				System.out.println("you lose! because of garbage");
				program.remove(player.getFish());
				return 1; 
			}
		}
		return 2;
	}

	public void addEnemy(int type) {
		Fish fish = new Fish(program);
		switch(type) {
		case 0: 
			if (fish.RtL) {
				fish.setFish("SmallFry.png");
				fish.getFish().scale(0.50);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(1);
			}
			else {
				fish.setFish("SmallFryFlipped.png");
				fish.getFish().scale(0.50);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(1);
			}
			break;
		case 1:
			if (fish.RtL) {
				fish.setFish("Nibbler.png");
				fish.getFish().scale(1.2);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(3);
			}
			else {
				fish.setFish("NibblerFlipped.png");
				fish.getFish().scale(1.2);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(3);
			}
			break;
		case 2:
			if (fish.RtL) {
				fish.setFish("TouchyFish.png");
				fish.getFish().scale(1.5);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(5);
			}
			else {
				fish.setFish("TouchyFishFlipped.png");
				fish.getFish().scale(1.5);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(5);
			}
			break;
		}
		program.add(fish.fishImage);
	}

	public void addAllFish() {
		for(Fish f: fishLtoR) {
			program.add(f.fishImage);
		}
		for(Fish f: fishRtoL) {
			program.add(f.fishImage);
		}
	}
	public void removeAllFish() {
		for(Fish f: fishLtoR) {
			program.remove(f.fishImage);
		}
		for(Fish f: fishRtoL) {
			program.remove(f.fishImage);
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
		
			if (pressed.size() > 1) { // if two keys are pressed, move diagonally
				Integer[] arr = pressed.toArray(new Integer[] {}); //save multiple key pressed into an array
				if ((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) ||
						(arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_RIGHT)){
					if(player.getRTL()) {
						player.getFish().setImage("PlainOldFishFlipped.png");
						player.setRTL(false);
					}
					player.getFish().move(2, -2);
				}
				else if((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_LEFT ) || 
						(arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_LEFT )) {
					if(!player.getRTL()) {
						player.getFish().setImage("PlainOldFish.png");
						player.setRTL(true);
					}
					player.getFish().move(-2, -2);
				}
				else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_RIGHT) ||
						(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_RIGHT)) {
					if(player.getRTL()) {
						player.getFish().setImage("PlainOldFishFlipped.png");
						player.setRTL(false);
					}
					player.getFish().move(2, 2);
				}
				else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_LEFT) ||
						(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_LEFT)) {
					if(!player.getRTL()) {
						player.getFish().setImage("PlainOldFish.png");
						player.setRTL(true);
					}
					player.getFish().move(-2, 2);
				}
			}
	
			else { // otherwise, move in one direction
				switch (keyPress) {
				case KeyEvent.VK_UP:
					player.getFish().move(0, -2);
					break;
				case KeyEvent.VK_DOWN:
					player.getFish().move(0, 2);
					break;
				case KeyEvent.VK_LEFT:
					if(!player.getRTL()) {
						player.getFish().setImage("PlainOldFish.png");
						player.setRTL(true);
					}
					player.getFish().move(-2, 0);
					break;
				case KeyEvent.VK_RIGHT:
					if(player.getRTL()) {
						player.getFish().setImage("PlainOldFishFlipped.png");
						player.setRTL(false);
					}
					player.getFish().move(2, 0);
					break;
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
	@Override
	public void keyReleased(KeyEvent e) {
		pressed.remove(Integer.valueOf(e.getKeyCode()));
		playerMove = false;
	}

	private void tick() {
		player.tick();
	}
}
