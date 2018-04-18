import java.awt.Container;

import acm.graphics.GLabel;

//kevin&silvana
public class Score implements Comparable<Score>{
	private String name;
	private int score;
	private GLabel scoreTxt;
	
	public Score() {
		name = "-";
		score = 0;
	}
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void increment(){
		this.score += 5;
		updateScoreTxt();
	}
	
	@Override
	public int compareTo(Score other) {
		if(this.getScore()>other.getScore()) {
			return 1;
		}
		if(this.getScore()==other.getScore()) {
			return 0;
		}
		return -1;
	}
	public GLabel getScoreTxt() {
		return scoreTxt;
	}
	public void setScoreTxt(GLabel scoreTxt) {
		this.scoreTxt = scoreTxt;
	}
	public void updateScoreTxt() {
		this.scoreTxt.setLabel(Integer.toString(score));
	}
	public GLabel getLabel() {
		// TODO Auto-generated method stub
		return scoreTxt;
	}
	
}
