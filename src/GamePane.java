//kyla
import java.awt.event.MouseEvent;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.*;
public class GamePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton pause;
	
	private GRect p1;
	private Player p;
	
	public GamePane(MainApplication app) {
		this.program = app;
		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());
		
		p = new Player();
		p1 = new GRect(program.WINDOW_WIDTH/2, program.WINDOW_HEIGHT/2, p.p.getSize()*5,p.p.getSize()*5);
		p1.setFillColor((p.p.getColor()));
		p1.setFilled(true);
		
	}

	@Override
	public void showContents() {
		program.add(pause);
		program.add(p1);
	}

	@Override
	public void hideContents() {
		program.remove(pause);
		program.remove(p1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == pause) {
			program.switchToPause();
		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("key:" + key);
		switch(key) {
		case KeyEvent.VK_UP:{
			p1.setLocation(p1.getX(), p1.getY() - 50);
			break;
		}
		case KeyEvent.VK_DOWN:{
			p1.setLocation(p1.getX(), p1.getY() +50);
			break;
		}
		case KeyEvent.VK_LEFT:{
			p1.setLocation(p1.getX()-50, p1.getY());
			break;
		}
		case KeyEvent.VK_RIGHT:{
			p1.setLocation(p1.getX() +50, p1.getY());
			break;
		}

		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:{
			
			break;
		}
		case KeyEvent.VK_DOWN:{

			break;
		}
		case KeyEvent.VK_LEFT:{

			break;
		}
		case KeyEvent.VK_RIGHT:{

			break;
		}

		}
	}


}
