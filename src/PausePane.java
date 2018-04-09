
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import acm.graphics.*;


public class PausePane extends GraphicsPane {
	private MainApplication program;

	private GButton sound;
	private GButton resume;
	private GButton quit;
	private GButton back;
	private GLabel pauseLabel;
	private GImage background;




	public PausePane(MainApplication app) {
		this.program = app;
		
		
		pauseLabel = new GLabel( "Pause", 200 , 50);
		pauseLabel.setFont("Forte-70");
		sound = new GButton ("Sound on",200,100,200,50 );
		sound.setFillColor(Color.RED);
		resume = new GButton("Resume", 200,200,200,50);
		resume.setFillColor(Color.RED);
		back = new GButton("Back to Menu",200,300,200,50);
		back.setFillColor(Color.RED);
		quit = new GButton("Quit Game", 200,400,200,50);
		quit.setFillColor(Color.RED);
		background = new GImage("pause.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(pauseLabel);
		if(!program.volume) {
			sound.setLabel("Sound off");
		}
		program.add(sound);
		program.add(resume);
		program.add(quit);
		program.add(back);
		
		
	}
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(pauseLabel);
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