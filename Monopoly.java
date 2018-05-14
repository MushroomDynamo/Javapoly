import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Math;
//import javafx.*;

public class Monopoly { //make all classes capital
	static LinkedList<boardSpace> boardOrder = new LinkedList<boardSpace>();
	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList<Card> chanceDeck = new ArrayList<Card>();
	static ArrayList<Card> communityDeck = new ArrayList<Card>();
	
	public static void main(String[] args) {
		initialize();
	}
	
	public static void initialize() {
		//board registry, currently temporary
		boardOrder.add(new boardSpaceGo(200));
		boardOrder.add(new boardSpaceProperty("Property 0", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 1", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 2", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 3", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 4", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 5", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 6", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 7", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 8", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property 9", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property A", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property B", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property C", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property D", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property E", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		boardOrder.add(new boardSpaceProperty("Property F", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		//boardOrder.add(new boardSpaceUtilityElectricity("Electricity", new int[] {500, 1000}, 800}));
		
		players.add(new Player(1000, getFirstInstanceOfSpace(boardSpaceGo.class, 0)));
		boardSpaceGo testSpace = (boardSpaceGo) getFirstInstanceOfSpace(boardSpaceGo.class, 0);
		if (testSpace instanceof boardSpaceGo) { //check that method recurses correctly
			System.out.println(testSpace.getAward());
		}
	}
	
	public static void processTurn(Player player) {
		//getFirstInstanceOfSpace(player.getPosition().getClass(),0)
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
	
	public static int rollDice(Player player) {
		int[] output = new int[2];
		output[0] = Math.floor(Math.random()*6); //possibly fold all this into a for loop later, need to think about efficiency of unraveling
		output[1] = Math.floor(Math.random()*6);
		if (output[0] == 0) {
			output[0] = 1;
		}
		if (output[1] == 0) {
			output[1] = 1;
		}
		return output[0] + output[1]; //will do things with the actual array and player object later
	}
}