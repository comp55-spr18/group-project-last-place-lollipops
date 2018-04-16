
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
	private GImage player;
	private GImage gameBackground;
	private GImage rock;
	private GButton pause;
	private GParagraph title;
	private final Set<Integer> pressed = new TreeSet<Integer>();
	private Fish fish;
	private Player p;
	private Score s;

	public boolean playerMove;
	public int key;
	double moveX = 0;
	double moveY = 0;

	public GamePane(MainApplication app) {
		this.program = app;
		fish = new Fish(app);
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
		player = new GImage("PlainOldFish.png", program.WINDOW_WIDTH / 2, program.WINDOW_HEIGHT / 2);
		//player.scale(0.65);
	/*	for (int i = 0; i < program.MAX_ENEMY; i++) {
			fish = new Fish(app);
		} */
		 System.out.println(program.fishLtoR.size() + ", " + program.fishRtoL.size());
	}

/*
	public int collisionInteractions(Entity o) {
		 0 = you lose
		  1 = collided with a fish but u ate it
		  2 = do nothing (at the momemnt)
		  
		 
		if (player.collideWith(o)) {
			if (o instanceof Fish) {
				if (((Fish) o).getSizeCounter() > player.getSizeCounter()) {
					System.out.println("you lose!");
					program.remove(player);
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
	*/
	
	public void addEnemy(int type) {
		fish = new Fish(program);
		switch(type) {
		case 0: 
			if (fish.RtL) {
			fish.setFish("SmallFry.png");
			fish.getFish().scale(0.50);
			fish.setSize(1);
			}
			else {
				fish.setFish("SmallFryFlipped.png");
				fish.getFish().scale(0.50);
				fish.setSize(1);
			}
			break;
		case 1:
			if (fish.RtL) {
				fish.setFish("Nibbler.png");
				fish.getFish().scale(1.2);
				fish.setSize(3);
			}
			else {
				fish.setFish("NibblerFlipped.png");
				fish.getFish().scale(1.2);
				fish.setSize(3);
			}
			break;
		case 2:
			if (fish.RtL) {
				fish.setFish("TouchyFish.png");
				fish.getFish().scale(1.5);
				fish.setSize(5);
			}
			else {
				fish.setFish("TouchyFishFlipped.png");
				fish.getFish().scale(1.5);
				fish.setSize(5);
			}
			break;
		}
		program.add(fish.fishImage);
		
	}
	
/*	public void addAllFish() {
		for (Fish fish : program.fishLtoR) {
			program.add(fish.fishImage);
		}
		for (Fish fish : program.fishRtoL) {
			program.add(fish.fishImage);
		}
	}*/
	
/*	public void removeAllFish() {
		for (Fish fish : program.fishLtoR) {
			program.fishLtoR.remove(fish.fishImage);
		}
		for (Fish fish : program.fishRtoL) {
			program.fishRtoL.remove(fish.fishImage);
		}
	}*/

	@Override
	public void showContents() {
		program.add(gameBackground);
		program.add(pause);
		program.add(title);
		program.add(s.getScoreTxt());
		//program.add(program.g.getGarbageImage());
		//addAllFish();
		program.add(player);
		program.movement.start();
	}

	@Override
	public void hideContents() {
		program.remove(gameBackground);
		program.remove(pause);
		program.remove(title);
		program.remove(s.getScoreTxt());
	//	program.g.removeGarbage();
		//removeAllFish();
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
/*	
	public void playerMovement() {
		pressed.add(keyPress); 
		if (pressed.size() > 1) { // if two keys are pressed, move diagonally
			Integer[] arr = pressed.toArray(new Integer[] {}); //save multiple key pressed into an array
			if ((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_RIGHT) ||
			    (arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_RIGHT)){
				player.setImage("PlainOldFishFlipped.png");
				player.move(5, -5);
			}
			else if((arr[0] == KeyEvent.VK_UP && arr[1] == KeyEvent.VK_LEFT ) || 
					(arr[1] == KeyEvent.VK_UP && arr[0] == KeyEvent.VK_LEFT )) {
				player.setImage("PlainOldFish.png");
				player.move(-5, -5);
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_RIGHT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_RIGHT)) {
				player.setImage("PlainOldFishFlipped.png");
				player.move(5, 5);
			}
			else if((arr[0] == KeyEvent.VK_DOWN && arr[1] == KeyEvent.VK_LEFT) ||
					(arr[1] == KeyEvent.VK_DOWN && arr[0] == KeyEvent.VK_LEFT)) {
				player.setImage("PlainOldFish.png");
				player.move(-5, 5);
			}
		}

		else { // otherwise, move in one direction
			switch (keyPress) {
			case KeyEvent.VK_UP:
				player.move(0, -5);
				break;
			case KeyEvent.VK_DOWN:
				player.move(0, 5);
				break;
			case KeyEvent.VK_LEFT:
				player.setImage("PlainOldFish.png");
				player.move(-5, 0);
				break;
			case KeyEvent.VK_RIGHT:
				player.setImage("PlainOldFishFlipped.png");
				player.move(5, 0);
				break;
			}
		}
	} */

/*	@Override
	public void keyPressed(KeyEvent e) {
		player.sendToFront();
		gameBackground.sendToBack();
		keyPress = e.getKeyCode();
		if(keyPress == KeyEvent.VK_RIGHT) {
			player.setImage("PlainOldFishFlipped.png");
			moveX = 5;
		}
		if(keyPress == KeyEvent.VK_LEFT) {
			player.setImage("PlainOldFish.png");
			moveY = -5;
		}
		if(keyPress == KeyEvent.VK_UP) {
			moveY = -5;
		}
		if(keyPress == KeyEvent.VK_DOWN) {
			moveX = 5;
		}
		player.move(moveX, moveY);
		playerMove = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(keyPress == KeyEvent.VK_RIGHT) {
			moveX = 0;
		}
		if(keyPress == KeyEvent.VK_LEFT) {
			moveX = 0;
		}
		if(keyPress == KeyEvent.VK_UP) {
			moveY = 0;
		}
		if(keyPress == KeyEvent.VK_DOWN) {
			moveY = 0;
		}
		pressed.remove(Integer.valueOf(e.getKeyCode()));
		playerMove = false;
	}
*/
	private void tick() {
		p.tick();
	}
	
	public void keyPressed(KeyEvent e) {
		player.sendToFront();
		gameBackground.sendToBack();
		key = e.getExtendedKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			player.setImage("PlainOldFishFlipped.png");
			p.setMoveX(5);
		}
		else if(key == KeyEvent.VK_LEFT) {
			player.setImage("PlainOldFish.png");
			p.setMoveX(-5);
		}
		else if(key == KeyEvent.VK_UP) {
			p.setMoveY(-5);
		}
		else if(key == KeyEvent.VK_DOWN) {
			p.setMoveY(5);
		}
		//player.move(moveX, moveY);
	}
	
	public void keyReleased(KeyEvent e) {
		key = e.getExtendedKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			player.setImage("PlainOldFishFlipped.png");
			p.setMoveX(0);
		}
		else if(key == KeyEvent.VK_LEFT) {
			player.setImage("PlainOldFish.png");
			p.setMoveX(0);
		}
		else if(key == KeyEvent.VK_UP) {
			p.setMoveY(0);
		}
		else if(key == KeyEvent.VK_DOWN) {
			p.setMoveY(0);
		}
		//player.move(moveX, moveY);
	}
}
