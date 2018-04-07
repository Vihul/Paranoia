package Model;

public class Player {
	private String name;
	private Player target;
	private Player predator;
	private int points;
	
	
	public Player(String playerName, Player playerTarget, Player playerPredator) {
		name = playerName;
		target = playerTarget;
		predator = playerPredator;
		points = 0;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void targetKilled(Player newTarget) {
		points++;
		target = newTarget;
	}
	
	public String getName() {
		return name;
	}
	
	public Player getTarget() {
		return target;
	}
	
	public Player setTarget(Player newTarget) {
		target = newTarget;
		return this;
	}
	
	public Player getPredator() {
		return predator;
	}
	
	public Player setPredator(Player newPredator) {
		predator = newPredator;
		return this;
	}
	
}
