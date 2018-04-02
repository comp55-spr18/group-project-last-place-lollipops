import java.awt.event.MouseEvent;

import java.io.*;


import acm.graphics.GObject;

public class LeaderboardsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private Score[] leaderboards;
	private GParagraph topTen;
	private GButton back;
	/*private FileReader in = null;
	private FileOutputStream out = null;
	private BufferedReader reader;
	*/
	public LeaderboardsPane(MainApplication app) /*throws IOException*/ {
		this.program = app;
		topTen = new GParagraph("THIS" + " IS\n" + "WHERE" + " THE\n" + "SCORES" + " GO\n", 200, 200);
		back = new GButton("Back", 200, 400, 200, 100);
		leaderboards = new Score[11];
		/*File f = new File("leaders.txt");
		if(!f.exists()) {
			f.createNewFile();
		}
		in = new FileReader("leaders.txt");
		reader = new BufferedReader(in);
		*/
	}

	@Override
	public void showContents() {
		program.add(topTen);
		program.add(back);
	}

	@Override
	public void hideContents() {
		program.remove(topTen);
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