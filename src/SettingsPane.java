import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class SettingsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton sound;
	private GImage background;
	private GButton back;
	private GRect rect1;
	private GLabel title;
	//private GObject object[]= {sound, background, back, rect1, title};


	public SettingsPane(MainApplication app) {
		this.program = app;
		sound = new GButton("Sound on", 280, 250, 200, 50);
		back = new GButton("Back", 280,350,200,50);
		background = new GImage("ocean.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		
		title = new GLabel( "Settings", 260 , 200);
		title.setFont("Century Gothic-bold-70");
		
		rect1=new GRect(180,120,program.WINDOW_WIDTH/2,program.WINDOW_HEIGHT/2);
		rect1.setFillColor(new Color(255,255,255,128));
		rect1.setFilled(true);
		rect1.setColor(Color.black);
		
		
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(rect1);
		program.add(title);
		if(!program.volume) {
			sound.setLabel("Sound off");
		}
		program.add(sound);
		program.add(back);
	}

	@Override
	public void hideContents() {
		//program.remove(object[]);
		program.remove(background);
		program.remove(rect1);
		program.remove(title);
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