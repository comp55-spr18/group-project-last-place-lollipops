import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;

//public class EnemyFish extends Fish{
/*	private MainApplication program;
	private ArrayList<Fish> fishLtoR;
	private ArrayList<Fish> fishRtoL;
	
	
	//constructor
	public EnemyFish(int speed, int size, double x, double y) {
		setSpeed(speed);
		setSize(size);
	}
	
	//functions
	public Fish makeFish() {
		fishLtoR = new ArrayList<Fish>();
		fishRtoL = new ArrayList<Fish>();
		Fish f = new Fish();
		
		int random = program.rgen.nextInt(0, 1);
		if (random == 0) {
			f.fish = new GImage("SmallFryFlipped.png", 0, program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			fishLtoR.add(f);
			return f;
		} else {
			f.fish = new GImage("SmallFry.png", program.WINDOW_WIDTH, program.rgen.nextInt(0, program.WINDOW_HEIGHT));
			fishRtoL.add(f);
			return f;
		}
	}
	
	public void addAllFish() {
		for (Fish f : fishLtoR) {
			f.setSize(1); // turn 1 into variable to alter size of fish
			program.add(f.fish);
		}
		for (Fish f : fishRtoL) {
			program.add(f.fish);
		}
	}

	public void removeAllFish() {
		for (Fish f : fishLtoR) {
			program.remove(f.fish);
		}
		for (Fish f : fishRtoL) {
			program.remove(f.fish);
		}
	}

//	public void moveAllFish() {
		for (Fish f : fishLtoR) {
			if (f.fish.getX() > program.WINDOW_WIDTH) {
				f.fish.setLocation(0, f.fish.getY());
			} else {
				f.fish.move(2, 0);
			}
		}
		for (Fish f : fishRtoL) {
			if (f.fish.getX() < 0) {
				f.fish.setLocation(program.WINDOW_WIDTH, f.fish.getY());
			} else {
				f.fish.move(-2, 0);
			}
		}
	}
	*/
	//public void moveEnemy() ???
//}
