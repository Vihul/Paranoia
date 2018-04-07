package Model;
import Player.java;

public class CircularLinkedList<Player> {
	
	private Player head;
	private Player tail;
	
	public CircularLinkedList() {
		head = null;
		tail = null;
		head.target = tail;
	}
	
	public CircularLinkedList<Player> add(Player element) {
		Player newPlayer = element;
		Player curr = head;
		
		if(head == null) {
			head = newPlayer;
			head.next = tail;
			tail.next = head;
			head.prev = tail;
			tail.prev = head; 
			tail = head;
			
			return this;
		}
		
		while(curr.getTarget() != head){
			
		}
	}
	
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
	}
}