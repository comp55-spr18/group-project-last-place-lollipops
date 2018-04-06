//kyla
import java.awt.event.MouseEvent;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.GImage;
import acm.graphics.GObject;
import java.util.*;


public class GamePane extends GraphicsPane  {
	private MainApplication program; 
	
	private GButton pause;
	private GImage player;
	private Player p;
	private GImage gameBackground;
	private GParagraph title;

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
		
		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());

		pause.setFillColor(Color.RED);
		p = new Player(2, 8, 50, 40, Color.green);
		gameBackground = new GImage("GamePane.jpg", 100, 100);
		player = new GImage("PlainOldFish.png",program.WINDOW_WIDTH/2, program.WINDOW_HEIGHT/2);


		for(int i =0; i < program.MAX_ENEMY; i++) {
			makeFish();
		}

		System.out.println(fishLtoR.size() +", "+fishRtoL.size());

	}
	public Fish makeFish() {
		Fish f = new Fish();
		int random = program.rgen.nextInt(0,1);
		if (random == 0) {
			f.fish = new GImage("SmallFry.png", 0,program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			fishLtoR.add(f);
			return f;
		}
		else {
			f.fish = new GImage("SmallFry.png", program.WINDOW_WIDTH,program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			fishRtoL.add(f);
			return f;
		}
	}
	public void addAllFish() {
		for (Fish f: fishLtoR) {
			program.add(f.fish);
		}
		for (Fish f: fishRtoL) {
			program.add(f.fish);
		}
	}
	public void removeAllFish() {
		for (Fish f: fishLtoR) {
			program.remove(f.fish);
		}
		for (Fish f: fishRtoL) {
			program.remove(f.fish);
		}
	}
	public void moveAllFish() {
		for (Fish f: fishLtoR) {
			if (f.fish.getX() > program.WINDOW_WIDTH) {
				f.fish.setLocation(0, f.fish.getY());
			}
			else {
				f.fish.move(2, 0);
			}
		}
		for (Fish f: fishRtoL) {
			if (f.fish.getX() < 0) {
				f.fish.setLocation(program.WINDOW_WIDTH, f.fish.getY());
			}
			else {
				f.fish.move(-2, 0);
			}
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
		switch(keyPress) {
		case KeyEvent.VK_UP:{
			player.move(0, -2);
			break;
		}
		case KeyEvent.VK_DOWN:{
			player.move(0, 2);
			break;
		}
		case KeyEvent.VK_LEFT:{
			player.move(-2, 0);
			break;
		}
		case KeyEvent.VK_RIGHT:{
			player.move(2, 0);
			break;
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
		playerMove = false;
	}



}
