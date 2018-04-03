
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;


public class PausePane extends GraphicsPane {
	private MainApplication program;
	
	private GButton sound;
	private GButton resume;
	private GButton quit;
	private GButton back;
	
	public PausePane(MainApplication app) {
		this.program = app;
		sound = new GButton ("Sound on",200,200,200,100 );
		resume = new GButton("Resume", 150,150,55,55);
		quit = new GButton("Quit Game", 400,200,100,100);
		back = new GButton("Back to Menu", 200, 400, 200, 100);
	}
	
	@Override
	public void showContents() {
		program.add(sound);
		program.add(resume);
		program.add(quit);
		program.add(back);
	}
	@Override
	public void hideContents() {
		program.remove(sound);
		program.remove(resume);
		program.remove(quit);
		program.remove(back);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		
		if (obj == back) {
			program.switchToMenu();
			program.pauseGameMusic();
			program.playMenuMusic();
		}
		if (obj == sound) {
			if (program.volume) {
				sound.setLabel("Sound off");
				program.volume = false;
				program.pauseMenuMusic();
				program.pauseGameMusic();
				}
			else {
				program.volume = true;
				sound.setLabel("Sound on");
				program.playGameMusic();
		}
			}
		if(obj== resume) {
			program.switchToGame();
		}
		if(obj == quit) {
			System.exit(0);
		}
	
	}
}