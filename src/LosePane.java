//kyla 
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import acm.graphics.*;


public class LosePane extends GraphicsPane {
	private MainApplication program;
	private Score score;
	private GButton sound;
	private GButton quit;
	private GButton back;
	private GLabel loseLabel;
	private GImage background;
	private GButton saveName;
	private GLabel playername;
	private TextField nameEnter;
	private GRect rect1;
	private GLabel yourscore;



	public LosePane(MainApplication app) {
		super();
		this.program = app;



		//title
		loseLabel = new GLabel( "You Died!", 220 , 100);
		loseLabel.setFont("Century Gothic-bold-70");
		loseLabel.setColor(Color.blue);

		//get score from gamePane
		score = program.getGame().getScore();


		//Score[] score = getScoreTxt();
		//score
		yourscore= new GLabel("Your Score: "+ score.getScore(), 200,170);
		yourscore.setFont("Century Gothic-30");

		//textbox
		playername=new GLabel("Please enter your name:", 200,250);
		playername.setFont("Century Gothic-30");

		nameEnter = new TextField();
		nameEnter.setBounds(280,300,200,50);
		
		
		Font font1 = new Font("Century Gothic", Font.BOLD, 40);
		nameEnter.setFont(font1);
		//save button for saving name and score
		saveName = new GButton("Save",280,400,200,50);

		//background rectangle
		rect1=new GRect(180,45,400,230);
		rect1.setFillColor(new Color(255,255,255,128));
		rect1.setFilled(true);
		rect1.setColor(Color.black);

		//all buttons
		if (program.volume) {
			sound = new GButton ("Sound on",60,500,200,50 );
		}else {
			sound = new GButton ("Sound off",60,500,200,50 );
		}
		sound.setFillColor(Color.white);
		back = new GButton("Back to Menu",280,500,200,50);
		back.setFillColor(Color.white);
		quit = new GButton("Quit Game", 500,500,200,50);
		quit.setFillColor(Color.white);
		background = new GImage("eatingfish.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add (rect1);
		program.add(nameEnter);
		program.add(loseLabel);
		program.add(yourscore);
		program.add(saveName);
		program.add(playername);
		program.add(sound);
		program.add(quit);
		program.add(back);

	}
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(nameEnter);
		program.remove(loseLabel);
		program.remove(playername);
		program.remove(saveName);
		program.remove(rect1);
		program.remove(playername);
		program.remove(yourscore);
		program.remove(sound);
		program.remove(quit);		
		program.remove(back);
		
	}

	public Score findScore() {
		return score;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());

		if (obj == back) {
			program.switchToMenu();
			program.stopLoseMusic();
			program.stopGameMusic();
		}
		if (obj == sound) {
			if (program.volume) {
				sound.setLabel("Sound off");
				program.volume = false;
				
				program.pauseLoseMusic();
			}
			else {
				program.volume = true;
				sound.setLabel("Sound on");
				program.playLoseMusic();
			}
		}

		if(obj == quit) {
			System.exit(0);
		}
		if(obj ==saveName) {
			//program.getInputContext();
			//nameEnter.getInputContext();
			if(nameEnter.getText().equals("") || nameEnter.getText().charAt(0) == ' ') {
				score.setName("-");
			}else {
				score.setName(nameEnter.getText());
			}
			program.updateLeaderboards();
			program.switchToLeaderboards();
		}

	}
}