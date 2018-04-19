
import java.awt.Color;
import java.awt.event.MouseEvent;


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
		
		
		pauseLabel = new GLabel( "Pause", 100 , 150);
		pauseLabel.setFont("Century Gothic-bold-200");
		pauseLabel.setColor(Color.red);
		sound = new GButton ("Sound on",300, 230, 200, 50 );
		sound.setFillColor(Color.white);
		resume = new GButton("Resume", 300, 330, 200, 50);
		resume.setFillColor(Color.white);
		back = new GButton("Back to Menu",300, 430, 200, 50);
		back.setFillColor(Color.white);
		quit = new GButton("Quit Game", 300, 530, 200, 50);
		quit.setFillColor(Color.white);
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
			program.stopGameMusic();
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