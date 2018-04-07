package Model;
import Player.java;

public class CircularLinkedList<Player> {
	
	private Player head;
	private Player tail;
	
	public CircularLinkedList() {
		head = null;
		tail = null;
		head.setTarget(tail);
	}
	
	public CircularLinkedList<Player> add(Player element) {
		Player newNode = new Player(element);
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
		
		while(curr.next != head){
			
		}
	}
	
	
	
	public class Node() {
		
		protected Player data;
		protected Node next;
		protected Node prev;
		
		
		public Node(Player nodeData) {
			data = nodeData;
			next = null;
			prev = null;
		}
	}