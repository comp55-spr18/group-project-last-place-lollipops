import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SettingsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton sound;
	private GImage background;
	private GButton back;

	public SettingsPane(MainApplication app) {
		this.program = app;
		sound = new GButton("Sound on", 280, 200, 200, 100);
		back = new GButton("Back", 280, 400, 200, 100);
		background = new GImage("ocean.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
	}

	@Override
	public void showContents() {
		program.add(background);
		if(!program.volume) {
			sound.setLabel("Sound off");
		}
		program.add(sound);
		program.add(back);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(sound);
		program.remove(back);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			program.switchToMenu();
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
				program.playMenuMusic();
			}
		}
	}

}