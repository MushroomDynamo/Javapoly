import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;
import java.util.Scanner;
//import javafx.*;

public class Monopoly { //make all classes capital
	static LinkedList<boardSpace> boardOrder = new LinkedList<boardSpace>();
	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList<Card> chanceDeck = new ArrayList<Card>();
	static ArrayList<Card> communityDeck = new ArrayList<Card>();
	static String input;
	static Scanner scanner = new Scanner(System.in);
	static Boolean gameInPlay = true;
	
	public static void main(String[] args) {
		initialize();
		while (gameInPlay) {
			Iterator<Player> iterator = players.iterator();
			while (iterator.hasNext()) {
				System.out.println("\n\nNext player's turn");
				processTurn(iterator.next());
			}
			System.out.println("Continue play? (y/n)");
			input = scanner.nextLine();
			if (input.equals("n")) {
				gameInPlay = false;
			}
			input = null;
		}
	}
	
	public static void initialize() {
		//board registry, currently temporary
		boardOrder.add(new boardSpaceGo(200));
		boardOrder.add(new boardSpaceProperty("Property 0", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 1", new int[] {150, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 2", new int[] {200, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 3", new int[] {250, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 4", new int[] {300, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 5", new int[] {350, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 6", new int[] {400, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 7", new int[] {450, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 8", new int[] {500, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 9", new int[] {550, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property A", new int[] {600, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property B", new int[] {650, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property C", new int[] {700, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property D", new int[] {750, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property E", new int[] {800, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property F", new int[] {850, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceJail());
		//boardOrder.add(new boardSpaceUtilityElectricity("Electricity", new int[] {500, 1000}, 800}));
		
		for (int i = 0; i < 4; i++) {
			players.add(new Player(1000, getFirstInstanceOfSpace(boardSpaceGo.class, 0)));
		}
		/*boardSpaceGo testSpace = (boardSpaceGo) getFirstInstanceOfSpace(boardSpaceGo.class, 0);
		if (testSpace instanceof boardSpaceGo) { //check that method recurses correctly
			System.out.println(testSpace.getAward());
		}*/
	}
	
	public static void processTurn(Player player) {
		int outputRoll = rollDice(player);
		player.setPosition(boardOrder.get(getFirstInstanceOfSpaceIndex(player.getPosition().getClass(),0) + outputRoll));
		System.out.println(outputRoll);
		System.out.println(player.getPosition()); //debug
		boardSpace position = player.getPosition();
		
		/*if (checkDoubles(player) == true) {
			System.out.println("Sent to jail");
			player.setPosition(getFirstInstanceOfSpace(boardSpaceJail.class, 0));
		} else*/ if (player.getPosition() instanceof boardSpaceProperty) {
			if (((boardSpaceProperty) player.getPosition()).getOwner() == null) {
				System.out.println("Would you like to purchase this property? Price is " + ((boardSpaceProperty) position).getRentData()[0] + " (y/n)");
				input = scanner.nextLine();
				if (input.equals("y")) {
					player.setFunds(player.getFunds() - ((boardSpaceProperty) position).getRentData()[0]);
					System.out.println("Your funds are now " + player.getFunds());
				}
			} else {
				System.out.println("This space is owned. Rent must be paid in the amount of " + ((boardSpaceProperty) position).getRentData()[1]);
				player.setFunds(player.getFunds() - ((boardSpaceProperty) position).getRentData()[1]); //need case for player ownership
			}
		} else if (player.getPosition() instanceof boardSpaceGoJail) {
			System.out.println("Sent to jail");
			player.setPosition(getFirstInstanceOfSpace(boardSpaceJail.class, 0));
		}
	}
	
	public static boardSpace getFirstInstanceOfSpace(Class spaceClass, int i) { //recursive method to acquire a specific space type
		if (i == boardOrder.size()) {
			return null;
		}
		if (boardOrder.get(i).getClass().equals(spaceClass)) {
			return boardOrder.get(i);
		} else {
			return getFirstInstanceOfSpace(spaceClass, i++);
		}
	}
	
	public static int getFirstInstanceOfSpaceIndex(Class spaceClass, int i) {
		if (i == boardOrder.size()) {
			return 0;
		}
		if (boardOrder.get(i).getClass().equals(spaceClass)) {
			return i;
		} else {
			return getFirstInstanceOfSpaceIndex(spaceClass, i++);
		}
	}
	
	public static int getSpaceIndex(boardSpace testSpace) {
		int i = 0;
		if (i == boardOrder.size()) {
			return 0;
		}
		if (boardOrder.get(i).equals(testSpace)) {
			return i;
		} else {
			return getSpaceIndex(testSpace);
		}
	}
	
	public static int rollDice(Player player) {
		int[] output = new int[2];
		output[0] = (int) Math.floor(Math.random()*6); //possibly fold all this into a for loop later, need to think about efficiency of unraveling
		output[1] = (int) Math.floor(Math.random()*6);
		if (output[0] == 0) {
			output[0] = 1;
		}
		if (output[1] == 0) {
			output[1] = 1;
		}
		player.addToRollHistory(output);
		return output[0] + output[1]; //will do things with the actual array and player object later
	}
	
	public static Boolean checkDoubles(Player player) {
		ArrayList<Integer[]> rollHistory = player.getRollHistory();
		Iterator<Integer[]> iterator = rollHistory.iterator();
		while (iterator.hasNext()) {
			Integer[] roll = iterator.next();
			if (!(roll[0].equals(roll[1]))) {
				return false;
			}
		}
		return true;
	}
}