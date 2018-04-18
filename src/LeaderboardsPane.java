import java.awt.Color;
import java.awt.event.MouseEvent;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Stream;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class LeaderboardsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	//private Score[] leaderboards;
	private GParagraph topTen;
	private GButton back;
	private FileReader in = null;
	private FileWriter out = null;
	private BufferedReader reader;
	private String line;
	private String[] splitline;
	private String workDir = System.getProperty("user.dir");
	private String newPath = "filepath";
	private GImage background;
	private GLabel title;
	private GParagraph number;

			
	public LeaderboardsPane(MainApplication app) {
		if(System.getProperty("os.name").split(" ")[0].equals("Windows")) {
			newPath = workDir.substring(0, workDir.lastIndexOf('\\')) + "\\src\\";
		}else {
			newPath = workDir.substring(0, workDir.lastIndexOf('/')) + "/src/";
			
		}
		this.program = app;
		topTen = new GParagraph("", 280, 140);
		back = new GButton("Back", 280,500,200,50);
		//leaderboards = new Score[11];
		Score[] leaderboards;
		leaderboards = getLeaders();
		
		//leaderboards[11] = playerScore;
		
		Arrays.sort(leaderboards, Collections.reverseOrder());
		displayLeaders(leaderboards);
		writeLeaders(leaderboards);
		System.out.println(workDir);
		System.out.println(System.getProperty("os.name"));
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println(newPath);
		background = new GImage("koi fish.gif",0,0);
		background.setBounds(0, 0, program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		title = new GLabel( "Top Ten Fish", 220 , 100);
		title.setFont("Century Gothic-bold-70");
		number = new GParagraph ("1. \n2. \n3. \n4. \n5. \n6. \n7. \n8. \n9. \n10.", 200,150);
		
		number.setFont("Century Gothic-bold-30");
		number.setColor(Color.orange);
	}
	
	public void writeLeaders(Score[] l) {
		try {
			out = new FileWriter(newPath + "leaders.txt"); //Update relative filepath to write to same file instead of creating new one
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			try {
				out.write(l[i].getName() + " " + l[i].getScore() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("file written");
	}
	
	public void displayLeaders(Score[] l) {
		for(int i=0;i<10;i++) {
			topTen.addText(l[i].getName() + " " + Integer.toString(l[i].getScore()) + "\n");
			topTen.setFont("Century Gothic-bold-30");
			topTen.setColor(Color.orange);
		}
	}
	
	
	public Score[] getLeaders() {
		Score[] scores = new Score[11];
		scores = Stream.generate(() -> new Score()).limit(11).toArray(Score[]::new);
		try {
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			in = new FileReader(newPath + "leaders.txt");
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
				scores[i].setName(splitline[0]);
				scores[i].setScore(Integer.valueOf(splitline[1]));
				System.out.println("Name: " + scores[i].getName());
				System.out.println("Score: " + scores[i].getScore() + "\n");
			}catch(NullPointerException ex) {
				//System.out.println("less than 10 scores.");
			}
			
		}
		try {
			reader.close();
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return scores;
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(title);
		program.add(topTen);
		program.add(number);
		program.add(back);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(title);
		program.remove(topTen);
		program.add(number);
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