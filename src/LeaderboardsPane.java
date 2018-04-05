import java.awt.event.MouseEvent;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Stream;

import acm.graphics.GObject;

public class LeaderboardsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	//private Score[] leaderboards;
	private GParagraph topTen;
	private GButton back;
	private FileReader in = null;
	private FileOutputStream out = null;
	private BufferedReader reader;
	private String line;
	private String[] splitline;
	
	public LeaderboardsPane(MainApplication app) {
		this.program = app;
		topTen = new GParagraph("", 200, 200);
		back = new GButton("Back", 200, 400, 200, 100);
		//leaderboards = new Score[11];
		Score[] leaderboards = Stream.generate(() -> new Score()).limit(11).toArray(Score[]::new);
		try {
			in = new FileReader("leaders.txt");
			reader = new BufferedReader(in);
		}catch(FileNotFoundException ex) {
			System.out.println("Could not open leaderboards.");
			ex.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				splitline = line.split(" ");
				leaderboards[i].setName(splitline[0]);
				leaderboards[i].setScore(Integer.valueOf(splitline[1]));
			}catch(NullPointerException ex) {
				System.out.println("less than 10 scores.");
			}
			
		}
		
		
		//leaderboards[11] = playerScore;
		
		
		//sort leaderboards by (int)Score highest -> lowest
		Arrays.sort(leaderboards, Collections.reverseOrder());
		
		for(int i=0;i<10;i++) {
			topTen.addText(leaderboards[i].getName() + " " + Integer.toString(leaderboards[i].getScore()) + "\n");
		}
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