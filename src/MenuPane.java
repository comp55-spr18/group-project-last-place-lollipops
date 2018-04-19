import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

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
	private GRect rect1;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		title = new GLabel ("Something Smells Fishy", 35, 70);
		title.setFont("Century Gothic-bold-65");
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
		
		rect1=new GRect(0,3,799,90);
		rect1.setFillColor(new Color(255,255,255,128));
		rect1.setFilled(true);
		rect1.setColor(Color.black);
		
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(rect1);
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
		program.remove(rect1);
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
