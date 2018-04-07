package src.Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.Model.CircularLinkedList;
import src.Model.CircularLinkedList.Player;

public class UserInterface {

	public static void main(String[] args) {
		CircularLinkedList playerList = new CircularLinkedList();
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		File file = new File("fixedNounList.txt");
		Scanner fileScan;
		Scanner keyboard = new Scanner(System.in);
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		while(true) {
			System.out.print("> ");
			String input = keyboard.next();
			
			if (input.equals("add_player")) {
				players.add(playerList.new Player(keyboard.next()));
			}
			
			else if (input.equals("print_list")) {
				playerList.printList();
			}
			
			else if (input.equals("create_game")) {
				while (fileScan.hasNextLine()) {
					words.add(fileScan.nextLine());
				}
				
				Collections.shuffle(words);
				playerList.addAll(players, words);
			}
			
			else if (input.equals("quit")) {
				break;
			}
			
			else {
				System.out.println("Invalid command");
			}
			
			keyboard.nextLine();
		}
		
		fileScan.close();
	}

}
