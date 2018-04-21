import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;

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
	public Score s;
	public ArrayList<Fish> fishLtoR = new ArrayList<Fish>();
	public ArrayList<Fish> fishRtoL = new ArrayList<Fish>();

	private GRect rect1;

	public GamePane(MainApplication app) {
		super();
		this.program = app;
		player = new Player(app, 0); // size 2
		player.img.scale(player.getScale());
		title = new GParagraph("Something Smells Fishy", 5, 30);
		title.setFont("Century Gothic-bold-30");
		title.setColor(Color.black);
		s = new Score();
		s.setScore(0);
		s.setScoreTxt(new GLabel(Integer.toString(s.getScore()),5,60));
		s.getLabel().setFont("Century Gothic-bold-25");
		s.getLabel().setColor(Color.black);
		//s.increment();

		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());
		pause.setFillColor(Color.white);

		gameBackground = new GImage("GamePane.jpg", 0, 0);
		gameBackground.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);

		rect1=new GRect(0,3,800,70);
		rect1.setFillColor(new Color(255,255,255,128));
		rect1.setFilled(true);
		rect1.setColor(Color.black);
		
	}
	
	public Player getPlayer() {
		return player;
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
					System.out.println(((Fish) o).getSize() +" vs " +player.getSize());
					System.out.println("you lose! because of bigger fish");
					program.remove(player.getFish());
					return 1; 
				}
				else {
					System.out.println("I ate a fish!");
					System.out.println(((Fish) o).getSize() +" vs " +player.getSize());
					program.remove(((Fish) o).getFish() );
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

	public void deleteAllFish() {
		for (Iterator<Fish> itr = fishLtoR.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			itr.remove();
			program.remove(f.img);
		}
		for (Iterator<Fish> itr = fishRtoL.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			itr.remove();
			program.remove(f.img);
		}
	}
	
	public void moveAllFish() {
		gameBackground.sendToBack();
		pause.sendToFront();
		for (Iterator<Fish> itr = fishLtoR.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			if (f.img.getX() > MainApplication.WINDOW_WIDTH + 50) {
				itr.remove();
				program.remove(f.img);
			} else {
				f.img.move(1, 0);
			}
		}
		for (Iterator<Fish> itr = fishRtoL.iterator(); itr.hasNext();) {
			Fish f = itr.next();
			if (f.img.getX() < -1* f.img.getWidth()) {
				itr.remove();
				program.remove(f.img);
			} else {
				f.img.move(-1, 0);
			}
		}
		
	}
	
	public void addEnemy(int type) {
		Fish fish = new Fish(program);
		switch(type) {
		case 0:  // allows for more chances of smaller fish
			if (fish.RtL) {
				fish.setFish("SmallFry.png");
				fish.img.setSize(90, 90);
				fish.getFish().scale(0.50);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(-1);
			}
			else {
				fish.setFish("SmallFryFlipped.png");
				fish.img.setSize(90, 90);
				fish.getFish().scale(0.50);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(-1);
			}
			break;
		case 1: 
			if (fish.RtL) {
				fish.setFish("Nibbler.png");
				fish.img.setSize(90, 90);
				fish.getFish().scale(1.0);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(3);
			}
			else {
				fish.setFish("NibblerFlipped.png");
				fish.img.setSize(90, 90);
				fish.getFish().scale(1.0);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(3);
			}
			break;
		case 2: 
			if (fish.RtL) {
				fish.setFish("TouchyFish.png");
				fish.img.setSize(90, 90);
				fish.getFish().scale(1.2);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(5);
			}
			else {
				fish.setFish("TouchyFishFlipped.png");
				fish.img.setSize(90, 90);
				fish.getFish().scale(1.2);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(5);
			}	
			break;
		case 3:
			if (fish.RtL) {
				fish.setFish("MysteryFish.png");
				fish.getFish().scale(0.8);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(7);
			}
			else {
				fish.setFish("MysteryFishFlipped.png");
				fish.getFish().scale(0.8);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(7);
			}	
			break;
		case 4:
			if (fish.RtL) {
				fish.setFish("KingofthePond.png");
				fish.getFish().scale(1);
				fish.getFish().setLocation(program.WINDOW_WIDTH,fish.getFish().getY());
				fish.setSize(9);
			}
			else {
				fish.setFish("KingofthePondFlipped.png");
				fish.getFish().scale(1);
				fish.getFish().setLocation(0-fish.getFish().getWidth(),fish.getFish().getY());
				fish.setSize(9);
			}	
			break;
	}
		System.out.println("type of fish: " + type + "\n");
		program.add(fish.img);
}
	
/*	public boolean checkSmallerFish() { //checks for a guaranteed smaller fish in the array
		boolean check = false;
		for(Fish f: fishLtoR) {
			if((f.getSize()/2) + 1 < (program.spawnTypes)) {
				check = true;
			}
		}
		for(Fish f: fishRtoL) {
			if((f.getSize()/2) + 1 < (program.spawnTypes)) {
				check = true;
			}
		}
		return check;
	}
	*/
	

	public void addAllFish() {
		for(Fish f: fishLtoR) {
			program.add(f.img);
		}
		for(Fish f: fishRtoL) {
			program.add(f.img);
		}
	}
	public void removeAllFish() {
		for(Fish f: fishLtoR) {
			program.remove(f.img);
		}
		for(Fish f: fishRtoL) {
			program.remove(f.img);
		}
	}
	@Override
	public void showContents() {
		program.add(gameBackground);
		program.add(rect1);
		program.movement.start();
		program.add(title);
		program.add(pause);
		program.add(s.getScoreTxt());
		addAllFish();
		program.add(player.getFish());

	}

	@Override
	public void hideContents() {
		program.remove(gameBackground);
		program.remove(rect1);
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
			if ( ((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) || (arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_RIGHT)) && (!player.isAtTop()) && (!player.isAtRight())){
				if(player.getRTL()) {
					player.getFish().setImage("PlainOldFishFlipped.png");
					player.getFish().setSize(90,90);
					player.img.scale(player.getScale());
					player.setRTL(false);
				}
				player.getFish().move(2, -2);
				
			}
			else if( ((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_LEFT ) || (arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_LEFT ) && (!player.isAtTop()) && (!player.isAtLeft())) 
					) {
				if(!player.getRTL()) {
					player.getFish().setImage("PlainOldFish.png");
					player.getFish().setSize(90,90);
					player.img.scale(player.getScale());
					player.setRTL(true);
				}
				player.getFish().move(-2, -2);
				
			}
			else if(((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_RIGHT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_RIGHT)) && (!player.isAtBottom()) && (!player.isAtRight()) ) {
				if(player.getRTL()) {
					player.getFish().setImage("PlainOldFishFlipped.png");
					player.getFish().setSize(90,90);
					player.img.scale(player.getScale());
					player.setRTL(false);
				}
				player.getFish().move(2, 2);
				
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_LEFT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_LEFT)  && (!player.isAtBottom()) && (!player.isAtLeft()) ) {
				if(!player.getRTL()) {
					player.getFish().setImage("PlainOldFish.png");
					player.getFish().setSize(90,90);
					player.img.scale(player.getScale());
					player.setRTL(true);
				}
				player.getFish().move(-2, 2);
				
			}
		}

		else { // otherwise, move in one direction
			switch (keyPress) {
			case KeyEvent.VK_UP:
				
				if(!player.isAtTop()) {
					player.getFish().move(0, -2);
				}
				break;
			case KeyEvent.VK_DOWN:
				
				if(!player.isAtBottom()) {
					player.getFish().move(0, 2);
				}
				break;
			case KeyEvent.VK_LEFT:
				
				if(!player.getRTL()) {
					player.getFish().setImage("PlainOldFish.png");
					player.getFish().setSize(90,90);
					player.img.scale(player.getScale());
					player.setRTL(true);
				}
				if(!player.isAtLeft()) {
					player.getFish().move(-2, 0);
				}
				break;
			case KeyEvent.VK_RIGHT:
				
				if(player.getRTL()) {
					player.getFish().setImage("PlainOldFishFlipped.png");
					player.getFish().setSize(90,90);
					player.img.scale(player.getScale());
					player.setRTL(false);
				}
				if(!player.isAtRight()) {
					player.getFish().move(2, 0);
				}
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
}
