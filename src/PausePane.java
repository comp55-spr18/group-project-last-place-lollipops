
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;


public class PausePane extends GraphicsPane {
	private MainApplication program;
	
	//private GButton pause;
	private GButton sound;
	private GButton resume;
	private GButton quit;
	private GButton back;
	
	public PausePane(MainApplication app) {
		this.program = app;
		//pause = new GButton ("Pause", 100,100, 50,50);
		sound = new GButton ("Sound on",200,200,200,100 );
		resume = new GButton("Resume", 150,150,55,55);
		quit = new GButton("Quit Game", 400,200,100,100);
		back = new GButton("Back to Menu", 200, 400, 200, 100);
	}
	
	@Override
	public void showContents() {
		//program.add(pause);
		program.add(sound);
		program.add(resume);
		program.add(quit);
		program.add(back);
	}
	@Override
	public void hideContents() {
		//program.add(pause);
		program.add(sound);
		program.add(resume);
		program.add(quit);
		program.add(back);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		//if (obj == pause) {
			
		//}
		if (obj == back) {
			program.switchToMenu();
		}
		if (obj == sound) {
			
		}
		if(obj== resume) {
			
		}
		if(obj == quit) {
			
		}
	}
	
}