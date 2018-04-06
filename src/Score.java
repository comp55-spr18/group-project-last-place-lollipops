//kevin&silvana
public class Score implements Comparable<Score>{
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
	
}
