import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class InstructionsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls

	private GLabel objective;
	private GParagraph para1;
	private GLabel watchout;
	private GParagraph para2;
	private GLabel howto;
	private GParagraph instructions;
	private GButton back;
	private GImage background;
	private GRect rect1;
	
	private GImage TouchyFish;
	private GImage NibblerFish;
	private GImage MysteryFish;
	private GImage KingFish;
	private GImage keys;

	public InstructionsPane(MainApplication app) {
		this.program = app;
		
		TouchyFish= new GImage("TouchyFish.png", 510,300);
		NibblerFish= new GImage("Nibbler.png",500,200);
		MysteryFish = new GImage("MysteryFish.png",110,210);
		KingFish = new GImage("KingofthePond.png",110,300);
		keys= new GImage("ARROWKEYS.png",370,380);
		keys.setSize(150,100);
		
		objective= new GLabel("Objective:",110,60 );
		objective.setFont("Century Gothic-bold-20");
		objective.setColor(Color.black);
		
		para1 = new GParagraph ("Eat smaller fish to grow in size.\nEat as much fish as you can to score,\nthe highest score possible.", 110,80);
		para1.setFont("Century Gothic-bold-15");
		para1.setColor(Color.black);
		
		watchout= new GLabel("Watch out for:",110,150 );
		watchout.setFont("Century Gothic-bold-20");
		watchout.setColor(Color.black);
		
		para2 = new GParagraph ("Bigger fish - They will eat you and you will die.\nThings that aren't fish may do something special.", 110,180);
		para2.setFont("Century Gothic-bold-15");
		para2.setColor(Color.black);
		
		howto=new GLabel("How to play:",120,400);
		howto.setFont("Century Gothic-bold-20");
		howto.setColor(Color.black);
		
		instructions = new GParagraph("Use arrow keys to move your fish.", 120, 450);
		
		instructions.setFont("Century Gothic-bold-15");
		instructions.setColor(Color.black);
		back = new GButton("Back", 280,500,200,50);
		
		background = new GImage("sunset.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		
		//background rectangle
		rect1=new GRect(100,30,500,460);
		rect1.setFillColor(new Color(255,255,255,128));
		rect1.setFilled(true);
		rect1.setColor(Color.black);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(rect1);
		program.add(NibblerFish);
		program.add(MysteryFish);
		program.add(TouchyFish);
		program.add(KingFish);
		program.add(keys);
		program.add(instructions);
		program.add(back);
		program.add(objective);
		program.add(para1);
		program.add(para2);
		program.add(howto);
		program.add(watchout);
	}

	@Override
	public void hideContents() {
		program.removeAll();
		program.remove(background);
		program.remove(rect1);
		program.remove(keys);
		program.remove(NibblerFish);
		program.remove(MysteryFish);
		program.remove(KingFish);
		program.remove(TouchyFish);
		program.remove(instructions);
		program.remove(back);
		program.remove(objective);
		program.remove(para1);
		program.remove(watchout);
		program.remove(para2);
		program.remove(howto);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			program.switchToMenu();
		}
		
	}

}