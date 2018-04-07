package src.Control;

import java.util.ArrayList;
import src.Model.CircularLinkedList;
import src.Model.CircularLinkedList.Player;

public class Runner {

	public static void main(String[] args) {
		CircularLinkedList playerList = new CircularLinkedList();
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		
		Player Clark = playerList.new Player("Clark");
		Player Cory= playerList.new Player("Cory");
		Player Michael = playerList.new Player("Michael");
		
		players.add(Clark);
		players.add(Cory);
		players.add(Michael);
		
		words.add("Pizza");
		words.add("Pencil");
		words.add("Kartik");
		
		playerList.addAll(players, words);
		
		playerList.printList();
	}

}
