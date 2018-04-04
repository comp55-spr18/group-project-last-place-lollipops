import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class InstructionsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GParagraph instructions;
	private GButton back;

	public InstructionsPane(MainApplication app) {
		this.program = app;
		instructions = new GParagraph("Just do it.", 200, 200);
		back = new GButton("Back", 200, 400, 200, 100);
	}

	@Override
	public void showContents() {
		program.add(instructions);
		program.add(back);
	}

	@Override
	public void hideContents() {
		program.remove(instructions);
		program.remove(back);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			program.switchToMenu();
		}
		
	}

}