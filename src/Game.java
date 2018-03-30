//kyla & dmitrij
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javafx.event.ActionEvent;

public class Game {
	
public Player person;
private int score;
private int level;
volatile boolean isPaused = false;
volatile boolean isClose = false;
int close;
private int resume;

public void run() {
	addMouseListerners();
	
}


private void addMouseListerners() {
	// TODO Auto-generated method stub
	
}


//checks if player lost 
//check size
// if hit
// if touch rock die

//boolean checkLose(){
//	if(person.size())
//	return false;
	
//}
//when the player wants to pause the game
//https://gamedev.stackexchange.com/questions/25177/implementing-pausing-functionality
boolean pause() {
	if(isPaused =true) {
	System.out.println("Game paused.");
	}
	return isPaused;
	
}
// closes application
void close() {
	if (isClose=true) {
		System.exit(0);
	}
}
//continues the game after they paused
void resume() {
	
}

public void actionPerformed(ActionEvent e) {
	
}
}
