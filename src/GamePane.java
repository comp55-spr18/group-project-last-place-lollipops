//kyla
import java.awt.event.MouseEvent;
import acm.graphics.GObject;
public class GamePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton pause;
	public GamePane(MainApplication app) {
		this.program = app;
		pause = new GButton("||", program.WINDOW_WIDTH, 10, 50, 50);
		pause.setLocation(pause.getX() - pause.getWidth() - 10, pause.getY());
	}

	@Override
	public void showContents() {
		program.add(pause);
	}

	@Override
	public void hideContents() {
		program.remove(pause);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == pause) {
			program.switchToPause();
		}

	}


}
