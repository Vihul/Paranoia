package src.Control;

import java.util.ArrayList;
import src.Model.CircularLinkedList;
import src.Model.CircularLinkedList.Player;

public class Runner {

	public static void main(String[] args) {
		CircularLinkedList<Player> playerList = new CircularLinkedList<Player>();
		ArrayList<Player> players = new ArrayList<>();
		
		Player Clark = playerList.new Player("Clark");
		Player Cory= playerList.new Player("Cory");
		Player Michael = playerList.new Player("Michael");
		
		players.add(Clark);
		players.add(Cory);
		players.add(Michael);
		
		playerList.addAll(players);
		
		playerList.printList();
	}

}
