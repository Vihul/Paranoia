package Model;
import java.util.ArrayList;

public class CircularLinkedList<Player> {
	
	private Player head;
	private Player tail;
	private ArrayList<Player> listOfTheFallen = null;
	
	public CircularLinkedList() {
		head = null;
		head.target = tail;
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
		}
	}
	
	
	
	public class Player {
		private String name;
		private Player target;
		private Player predator;
		private int points;
		private boolean isSafeForTheWeek;
		
		
		public Player(String playerName, Player playerTarget, Player playerPredator) {
			name = playerName;
			target = playerTarget;
			predator = playerPredator;
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
	}
}
