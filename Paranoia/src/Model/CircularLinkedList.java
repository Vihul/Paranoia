package src.Model;
import java.util.ArrayList;

public class CircularLinkedList {
	
	private Player head;
	private ArrayList<Player> listOfTheFallen;
	//private ArrayList<Player> listOfTotalPlayers;
	private ArrayList<String> magicWordList;
	private int numberOfPlayers;
	private static int daysSinceLastCullingOfTheHerd = 0;
	
	public CircularLinkedList() {
		head = null;
		numberOfPlayers = 0;
	}

	public void addAll(ArrayList<Player> playerList, ArrayList<String> magicWords) {
		magicWordList = magicWords;
		
		Player curr = head;
		
		for(int i = 0; i < playerList.size(); i++) {
		
			Player newPlayer = playerList.get(i);
			newPlayer.setMagicWord(magicWordList.remove(0));
			
			if(head == null) {
				head = newPlayer;
				head.target = head;
				head.predator = head;
			}
		
			else {
				while(curr.target != head){
					curr = curr.target;
				}
				curr.target = newPlayer;
				newPlayer.predator = curr;
			}
			
			newPlayer.target = head;
			
			numberOfPlayers++;
			curr = head;
		}
	}
	
	public void endOfDay() {
		daysSinceLastCullingOfTheHerd++;
		if(daysSinceLastCullingOfTheHerd >= 6) {
			cullTheHerd();
		}
	}
	
	//TODO: find out how to do time in java, serializable
	
	private void cullTheHerd() {
		Player curr = head;
		
		while(curr.target != head) {
			if(curr.isSafeForTheWeek) {
				curr = curr.target;
			}
			else {
				listOfTheFallen.add(curr);
				curr.predator.setMagicWord(magicWordList.remove(0));
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
		
		while (!curr.equals(head)) {
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
		
		killer.isSafeForTheWeek = true;
		killer.points++;
		
		killer.target = newTarget;
	}
	
	public String findWordOfPlayer(String playerName) {
		if(findPlayer(playerName) != null) {
			return findPlayer(playerName).getMagicWord();
		}
		else {
			return null;
		}
	}

	public void printList() {
		Player curr = head;
		
		do {
			System.out.println("Player name: " + curr.name + ", Points: " +
					curr.points + " Target: " + curr.target);
			curr = curr.target;
		} while (curr != head);
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
		
		public String toString() {
			return this.name;
		}
		
		public int getPoints() {
			return points;
		}
		
		public void targetKilled() {
			removePlayer(this.target);
		}
		
		public String getName() {
			return name;
		}
		
		public String getMagicWord() {
			return magicWord;
		}
		
		public void setMagicWord(String newMagicWord) {
			magicWord = newMagicWord;
		}
	}
}
