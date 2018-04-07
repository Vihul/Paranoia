package src.Model;
import java.util.ArrayList;

public class CircularLinkedList<Player> {
	
	private Player head;
	private Player tail;
	private ArrayList<Player> listOfTheFallen = null;
	private int numberOfPlayers;
	private static int daysSinceLastCullingOfTheHerd = 0;
	
	public CircularLinkedList() {
		head = null;
		head.target = tail;
		numberOfPlayers = 0;
	}
	
	public void addAll(ArrayList<Player> playerList) {
		Player curr = head;
		
		for(int i = 0; i < playerList.size(); i++) {
		
			Player newPlayer = playerList.get(i);
			
			if(head == null) {
				head = newPlayer;
				head.target = head;
				head.predator = head;
			}
		
			while(curr.target != head){
				curr = curr.target;
			}
			
			curr.target = newPlayer;
			newPlayer.target = head;
			newPlayer.predator = curr;
			
			numberOfPlayers++;
		}
	}
	
	public void endOfDay() {
		daysSinceLastCullingOfTheHerd++;
		if(daysSinceLastCullingOfTheHerd >= 6) {
			cullTheHerd();
		}
	}
	
	private void cullTheHerd() {
		Player curr = head;
		
		while(curr.target != head) {
			if(curr.isSafeForTheWeek) {
				curr = curr.target;
			}
			else {
				listOfTheFallen.add(curr);
				curr.predator.target = curr.target;
				curr.target.predator = curr.predator;
			}
		}
		
		listOfTheFallen.add(curr);
		curr.predator.target = curr.target;
		curr.target.predator = curr.predator;
		
	}
	
	public Player findCurrentLeader() {
		Player curr = head;
		Player winnerWinnerOstrichDinner = curr;
		
		while(curr.target != head) {
			if(curr.getPoints() > winnerWinnerOstrichDinner.getPoints()) {
				winnerWinnerOstrichDinner = curr;
			}
			
			curr = curr.target;
		}
		return winnerWinnerOstrichDinner;
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public Player findPlayer(String playerName) {
		Player curr = head.target;
		
		while (curr != head) {
			if (curr.name.compareTo(playerName) == 0) {
				return curr;
			}
			
			curr = curr.target;
		}
		
		return null;
	}
	
	public void removePlayer(Player dying) {
		Player killer = dying.predator;
		Player newTarget = dying.target;
		
		killer.target = newTarget;
	}
	
	public void printList() {
		Player curr = head;
		
		while (curr != head) {
			System.out.println("Player name: " + curr.name);
		}
	}
	
	//beginning of Player class
	public class Player {
		private String name;
		private Player target;
		private Player predator;
		private String magicWord;
		private int points;
		private boolean isSafeForTheWeek;
		
		
		public Player(String playerName) {
			name = playerName;
			points = 0;
			isSafeForTheWeek = false;
		}
		
		public int getPoints() {
			return points;
		}
		
		public void targetKilled(Player newTarget) {
			points++;
			target = newTarget;
			isSafeForTheWeek = true;
		}
		
		public String getName() {
			return name;
		}
		
		public String getMagicWord() {
			return magicWord;
		}
	}
}
