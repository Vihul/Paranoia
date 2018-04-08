package src.Model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CircularLinkedList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Player head;
	private ArrayList<Player> listOfTheFallen;
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
	
	//TODO: find out how to do time in java
	
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
	
	public void saveList(String fileName) {
		File file = new File(fileName);
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
	
			output.writeObject(this);
			output.close();
		}
		catch (Exception e) {
			System.out.println("File could not be saved");
		}
	}
	
	public CircularLinkedList loadList(String fileName) {
		File file = new File(fileName);

		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			CircularLinkedList list =  (CircularLinkedList) input.readObject();
			input.close();
			return list;
		}
		catch (Exception E) {
			return new CircularLinkedList();
		}
	}
	
	//beginning of Player class
	public class Player implements Serializable {
		private static final long serialVersionUID = 1L;
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
