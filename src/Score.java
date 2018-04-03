//kevin&silvana
public class Score {
	private String name;
	private int score;
	
	public Score() {
		name = "";
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
	
}
