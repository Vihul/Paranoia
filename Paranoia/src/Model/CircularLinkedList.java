package Model;

public class CircularLinkedList<Player> {
	
	private Player head;
	private Player tail;
	
	public CircularLinkedList() {
		head = null;
		tail = null;
		head.getTarget() = tail;
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
		
		while(curr.next != head){
			
		}
	}
}
