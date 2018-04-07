package Model;

public class CircularLinkedList<Player> {
	
	private Node head;
	private Node tail;
	
	public CircularLinkedList() {
		head = null;
		tail = null;
		head.next = tail;
	}
	
	public CircularLinkedList<Player> add(Player element) {
		Node newNode = new Node(element);
		Node curr = head;
		
		if(head == null) {
			head = newNode;
			head.next = tail;
			tail.next = head;
			head.prev = tail;
			tail.prev = head; 
			tail = head;
			
			return this;
		}
		
		if(head.next == null) {
			head.next = newNode;
			tail = newNode;
			tail.prev = head;
			tail.next = head;
			head.prev = tail;
			head.next = tail;
			
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
	
}
