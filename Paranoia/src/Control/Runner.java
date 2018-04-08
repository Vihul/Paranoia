package src.Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.Model.CircularLinkedList;
import src.Model.CircularLinkedList.Player;

public class Runner {

	public static void main(String[] args) {
		CircularLinkedList playerList = new CircularLinkedList();
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		File file = new File("fixedNounList.txt");
		Scanner fileScan;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		Player Clark = playerList.new Player("Clark");
		Player Corey = playerList.new Player("Corey");
		Player Michael = playerList.new Player("Michael");
		
		players.add(Clark);
		players.add(Corey);
		players.add(Michael);
		
		while (fileScan.hasNextLine()) {
			words.add(fileScan.nextLine());
		}
		
		Collections.shuffle(words);
		
		playerList.addAll(players, words);
		
		playerList.printList();
		
		System.out.println("Deleting Michael");
		
		playerList.removePlayer(Michael);
		
		playerList.printList();
		
		System.out.println("Deleting Corey");
		
		playerList.removePlayer(Corey);
		
		playerList.printList();
		
		fileScan.close();
	}

}
