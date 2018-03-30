import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class SettingsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton sound;
	private GButton back;

	public SettingsPane(MainApplication app) {
		this.program = app;
		sound = new GButton("Sound on", 200, 200, 200, 100);
		back = new GButton("Back", 200, 400, 200, 100);
	}

	@Override
	public void showContents() {
		program.add(sound);
		program.add(back);
	}

	@Override
	public void hideContents() {
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
			sound.setLabel("sound off");
		}
	}

}