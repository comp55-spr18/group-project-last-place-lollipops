//kyla 
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

import acm.graphics.*;


public class LosePane extends GraphicsPane {
	private MainApplication program;
//set score to name.
	private GButton sound;
	private GButton quit;
	private GButton back;
	private GLabel loseLabel;
	private GImage background;
	private GRectangle rect1;
	
	
	public LosePane(MainApplication app) {
		this.program = app;
		

		Score name = getName();
		
		
		loseLabel = new GLabel( "You Died!", 220 , 100);
		loseLabel.setFont("Century Gothic-bold-70");
		loseLabel.setColor(Color.blue);
		sound = new GButton ("Sound on",60,300,200,50 );
		sound.setFillColor(Color.RED);
		back = new GButton("Back to Menu",280,300,200,50);
		back.setFillColor(Color.RED);
		quit = new GButton("Quit Game", 500,300,200,50);
		quit.setFillColor(Color.RED);
		background = new GImage("fishbackground.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		rect1 = new GRectangle( 200,100,200,50);
	}

	private Score getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(loseLabel);
		program.add(sound);
		program.add(quit);
		program.add(back);
		
	}
	@Override
	public void hideContents() {
		program.remove(background);
	
		program.remove(loseLabel);
		program.remove(sound);
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
		
		if(obj == quit) {
			System.exit(0);
		}
		
	}
}