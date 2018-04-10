import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton play;
	private GButton settings;
	private GButton instructions;
	private GButton leaderboards;
	private GButton quit;
	private GImage background;
	private GLabel title;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		title = new GLabel ("Something Smells Fishy", 50, 50);
		title.setFont("Forte-70");
		background = new GImage("flower.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		background.sendBackward();
		play = new GButton("Play", 300, 100, 200, 50);
		play.setFillColor(Color.white);
		settings = new GButton("Settings", 300, 200, 200, 50);
		settings.setFillColor(Color.white);
		instructions = new GButton("Instructions", 300, 300, 200, 50);
		instructions.setFillColor(Color.white);
		leaderboards = new GButton("Leaderboards", 300, 400, 200, 50);
		leaderboards.setFillColor(Color.white);
		quit = new GButton("Quit",300, 500, 200, 50);
		quit.setFillColor(Color.white);
		
	
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(title);
		program.add(play);
		program.add(settings);
		program.add(instructions);
		program.add(leaderboards);
		program.add(quit);
	}
	

	@Override
	public void hideContents() {
		program.remove(title);
		program.remove(play);
		program.remove(settings);
		program.remove(instructions);
		program.remove(leaderboards);
		program.remove(quit);
		program.remove(background);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) {
			program.switchToNewGame();
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
		if (obj == quit) {
			System.exit(0);
			}
	}
}
