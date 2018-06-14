import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;
import java.util.Scanner;

public class Monopoly {
	static ArrayList<boardSpace> boardOrder = new ArrayList<boardSpace>();
	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList<Card> chanceDeck = new ArrayList<Card>();
	static ArrayList<Card> communityDeck = new ArrayList<Card>();
	static String input;
	static int integerInput;
	static Scanner scanner = new Scanner(System.in);
	static Boolean gameInPlay = true;
	
	// Add easy-to-use fields for special spaces
	static boardSpaceGo go = new boardSpaceGo(200);
	static boardSpaceJail jail = new boardSpaceJail();
	
	public static void main(String[] args) {
		initialize();
		while (gameInPlay) {
			if (players.size() == 0) {
				System.out.println("The game is over! Only one player left.");
				break;
			}
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
		//BOARD REGISTRY
		boardOrder.add(go);
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
		boardOrder.add(jail);
		boardOrder.add(new boardSpaceUtilityElectricity("Electricity", new int[] {500, 1000}, 800));
		boardOrder.add(new boardSpaceCard());
		boardOrder.add(new boardSpaceProperty("Property 10", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 11", new int[] {150, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 12", new int[] {200, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 13", new int[] {250, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 14", new int[] {300, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 15", new int[] {350, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 16", new int[] {400, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 17", new int[] {450, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 18", new int[] {500, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 19", new int[] {550, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 1A", new int[] {600, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 1B", new int[] {650, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 1C", new int[] {700, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 1D", new int[] {750, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 1E", new int[] {800, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 1F", new int[] {850, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceUtilityWater("Water", new int[] {500, 1000}, 800));
		boardOrder.add(new boardSpaceGoJail(jail));
		boardOrder.add(new boardSpaceCard());
		boardOrder.add(new boardSpaceProperty("Property 20", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 21", new int[] {150, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 22", new int[] {200, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 23", new int[] {250, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 24", new int[] {300, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 25", new int[] {350, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 26", new int[] {400, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 27", new int[] {450, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 28", new int[] {500, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 29", new int[] {550, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 2A", new int[] {600, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 2B", new int[] {650, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 2C", new int[] {700, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 2D", new int[] {750, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 2E", new int[] {800, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 2F", new int[] {850, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceCard());
		
		
		for (int i = 0; i < 4; i++) { //Register players
			players.add(new Player(1000, getFirstInstanceOfSpace(boardSpaceGo.class, 0)));
		}
	}
	
	public static void processTurn(Player player) {
		
		if (player.getFunds() <= 0) { //Check whether to boot player from the game
			System.out.println("You are out of the game! No funds remaining!");
			int playerToRemoveIndex = players.indexOf(player);
			players.remove(playerToRemoveIndex);
		} else {
			managePlayerProperties(player);
			
			int outputRoll = rollDice(player);
			if (boardOrder.indexOf(player.getPosition()) + outputRoll > (boardOrder.size() - 1)) {
				int difference = boardOrder.size() - boardOrder.indexOf(player.getPosition());
				player.setPosition(go);
				player.setFunds(player.getFunds() + go.getAward());
				System.out.println("Passed go! You receive " + go.getAward());
				player.setPosition(boardOrder.get(boardOrder.indexOf(player.getPosition()) + (outputRoll - difference)));
			} else {
				player.setPosition(boardOrder.get(boardOrder.indexOf(player.getPosition()) + outputRoll));
			}
			System.out.println(outputRoll);
			boardSpace position = player.getPosition();
			if (position instanceof boardSpaceProperty) {
				System.out.println("You have landed on Property: " + ((boardSpaceProperty) position).getTitle());
			}
			
			if (checkDoubles(player) == true) {
				System.out.println("Sent to jail");
				player.setPosition(jail);
			} else if (player.getPosition() instanceof boardSpaceProperty) {
				if (((boardSpaceProperty) player.getPosition()).getOwner() == null) {
					System.out.println("Would you like to purchase this property? Price is " + ((boardSpaceProperty) position).getRentData()[0] + " (y/n)");
					input = scanner.nextLine();
					if (input.equals("y")) {
						player.setFunds(player.getFunds() - ((boardSpaceProperty) position).getRentData()[0]);
						System.out.println("Your funds are now " + player.getFunds());
	               ((boardSpaceProperty) player.getPosition()).setOwner(player);
					}
				} else {
					System.out.println("This space is owned. Rent must be paid in the amount of " + ((boardSpaceProperty) position).getRentData()[1]);
					player.setFunds(player.getFunds() - ((boardSpaceProperty) position).getRentData()[1]);
	            ((boardSpaceProperty) position).getOwner().setFunds(((boardSpaceProperty) position).getOwner().getFunds() + ((boardSpaceProperty) position).getRentData()[1]);
				}
			} else if (player.getPosition() instanceof boardSpaceGoJail) {
				System.out.println("Sent to jail");
				player.setPosition(jail);
			} else if (player.getPosition() instanceof boardSpaceCard) {
				int cardID = (int) Math.floor(Math.random() * 4);
				switch (cardID) {
					case 0:
						System.out.println("You drew a card! Go directly to jail.");
						player.setPosition(jail);
						break;
					case 1:
						System.out.println("You drew a card! Go directly to GO and collect $" + go.getAward());
						player.setPosition(go);
						player.setFunds(player.getFunds() + go.getAward());
						break;
					case 2:
						System.out.println("You drew a card! You gain $1,000 from a lottery ticket.");
						player.setFunds(player.getFunds() + 1000);
						break;
					case 3:
						System.out.println("You drew a card! You lose $1,000 due to updated tax code.");
						player.setFunds(player.getFunds() - 1000);
						break;
				}
			}
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
	
	public static int getFirstInstanceOfSpaceIndex(Class spaceClass, int i) { //recursive method to acquire a space type's index
		if (i == boardOrder.size()) {
			return 0;
		}
		if (boardOrder.get(i).getClass().equals(spaceClass)) {
			return i;
		} else {
			return getFirstInstanceOfSpaceIndex(spaceClass, i++);
		}
	}
	
	public static int getSpaceIndex(boardSpace testSpace) { //recursive method to get a specifc space's index (using an object reference)
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
	
	public static int rollDice(Player player) { //Rolls two dice for player movement
		int[] output = new int[2];
		output[0] = (int) Math.floor(Math.random()*6);
		output[1] = (int) Math.floor(Math.random()*6);
		if (output[0] == 0) {
			output[0] = 1;
		}
		if (output[1] == 0) {
			output[1] = 1;
		}
		player.addToRollHistory(output);
		return output[0] + output[1];
	}
	
	public static Boolean checkDoubles(Player player) { //Has the player rolled enough doubles to go to jail?
		ArrayList<Integer[]> rollHistory = player.getRollHistory();
		Iterator<Integer[]> iterator = rollHistory.iterator();
      int counter = 3;
		while (iterator.hasNext()) {
			Integer[] roll = iterator.next();
			if (!(roll[0].equals(roll[1]))) {
				return false;
			}
         counter--;
		}
      if (counter == 0) {
		   return true;
      } else {
         return false;
      }
	}
   
   public static ArrayList<boardSpace> dumpOwnership(Player player) { //Get all properties a player owns.
		ArrayList<boardSpace> properties = new ArrayList<boardSpace>();
		Iterator<boardSpace> iterator = boardOrder.iterator();
		while (iterator.hasNext()) {
			boardSpace property = iterator.next();
			if (property instanceof boardSpaceProperty) {
				boardSpaceProperty propertyP = (boardSpaceProperty) property;
				if (player.equals(propertyP.getOwner())) {
					properties.add(propertyP);
				}
			} else if (property instanceof boardSpaceUtility) {
				boardSpaceUtility propertyU = (boardSpaceUtility) property;
				if (player.equals(propertyU.getOwner())) {
					properties.add(propertyU);
				}
			}
		}
		return properties;
	}
	
	public static void managePlayerProperties(Player player) { //Property management function.
		boardSpace property;
		boardSpaceProperty propertyP;
		boardSpaceUtility propertyU;
		
		System.out.println("Would you like to manage your properties? (y/n)");
		input = scanner.nextLine();
		if (input.equals("n")) {
			return;
		}
		
		while (true) {
			ArrayList<boardSpace> properties = dumpOwnership(player);
			Iterator<boardSpace> iterator = properties.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				property = iterator.next();
				if (property instanceof boardSpaceProperty) {
					propertyP = (boardSpaceProperty) property;
					System.out.println(i + ": " + propertyP.getTitle());
				} else if (property instanceof boardSpaceUtility) {
					propertyU = (boardSpaceUtility) property;
					System.out.println(i + ": " + propertyU.getTitle());
				} else { //UNSUPPORTED OWNERSHIP TYPE!!
					return;
				}
				i++;
			}
			if (properties.size() == 0) {
				System.out.println("Error. No properties to manage.");
				return;
			}
			System.out.println("Please type the index of the property you wish to manage.");
			integerInput = scanner.nextInt();
			property = properties.get(integerInput);
			if (property instanceof boardSpaceProperty) {
				propertyP = (boardSpaceProperty) property;
				System.out.println("Managing property " + propertyP.getTitle());
				System.out.println("A house costs " + propertyP.getRentData()[6] + ". Your funds are " + player.getFunds() + ". Purchase? (y/n)");
				input = scanner.nextLine();
				if (!input.equals("n")) {
					System.out.println("Purchased!");
					player.setFunds(player.getFunds() - propertyP.getRentData()[6]); //needs validity checks
					propertyP.setHouses(propertyP.getHouses() + 1); //also validity checks
				}
			} else if (property instanceof boardSpaceUtility) {
				propertyU = (boardSpaceUtility) property;
				System.out.println("Managing a utility.");
			}
			
			System.out.println("Done managing properties? (y/n)");
			input = scanner.nextLine();
			if (input.equals("y")) {
				return;
			}
		}
	}
}