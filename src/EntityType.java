
public enum EntityType {
	KELP, HOOK, FISH, ROCK, SPEEDBUFF;
	public String toString() {
		switch(this) {
		case KELP: return "kelp";
		case HOOK: return "hook";
		case FISH: return "fish";
		case ROCK: return "rock";
		case SPEEDBUFF: return "speedbuff";
		}
		return "n/a";
	}
}
