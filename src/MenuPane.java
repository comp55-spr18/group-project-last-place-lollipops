import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton play;
	private GButton settings;
	private GButton instructions;
	private GButton leaderboards;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		play = new GButton("Play", 200, 100, 200, 50);
		play.setFillColor(Color.RED);
		settings = new GButton("Settings", 200, 200, 200, 50);
		settings.setFillColor(Color.RED);
		instructions = new GButton("Instructions", 200, 300, 200, 50);
		instructions.setFillColor(Color.RED);
		leaderboards = new GButton("Leaderboards", 200, 400, 200, 50);
		leaderboards.setFillColor(Color.RED);
	}

	@Override
	public void showContents() {
		program.add(play);
		program.add(settings);
		program.add(instructions);
		program.add(leaderboards);
	}

	@Override
	public void hideContents() {
		program.remove(play);
		program.remove(settings);
		program.remove(instructions);
		program.remove(leaderboards);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) {
			program.switchToSome();
		}
		if (obj == settings) {
			program.switchToSettings();
		}
		if (obj == instructions) {
			program.switchToInstructions();
		}
		if (obj == leaderboards) {
			program.switchToLeaderboards();
		}
	}
}
