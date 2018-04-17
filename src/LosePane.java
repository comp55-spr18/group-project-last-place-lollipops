//kyla 
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import acm.graphics.*;


public class LosePane extends GraphicsPane {
	private MainApplication program;
//set score to name.
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
		this.program = app;
		loseLabel = new GLabel( "You Died!", 220 , 100);
		loseLabel.setFont("Century Gothic-bold-70");
		loseLabel.setColor(Color.blue);
		
		Score score = getScore();
		
		yourscore= new GLabel("Your Score: "+score, 200,170);
		yourscore.setFont("Century Gothic-30");
		
		playername=new GLabel("Please enter your name:", 200,250);
		playername.setFont("Century Gothic-30");
		
		nameEnter = new TextField();
		nameEnter.setBounds(280,300,200,50);
		Font font1 = new Font("Century Gothic", Font.BOLD, 50);
		nameEnter.setFont(font1);
		saveName = new GButton("Save",280,400,200,50);
		
		Score name = getName();
		
		rect1=new GRect(180,45,400,230);
		rect1.setFillColor(Color.white);
		rect1.setFilled(true);
		rect1.setColor(Color.black);
		
		
		sound = new GButton ("Sound on",60,500,200,50 );
		sound.setFillColor(Color.RED);
		back = new GButton("Back to Menu",280,500,200,50);
		back.setFillColor(Color.RED);
		quit = new GButton("Quit Game", 500,500,200,50);
		quit.setFillColor(Color.RED);
		background = new GImage("fishbackground.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
	}

	private Score getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	private Score getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add (rect1);
		program.add(loseLabel);
		program.add(yourscore);
		program.add(nameEnter);
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
		if(obj ==saveName) {
			
		}
		
	}
}