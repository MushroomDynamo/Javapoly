import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Math;
//import javafx.*;

public class Monopoly { //make all classes capital
	LinkedList<boardSpace> boardOrder = new LinkedList<boardSpace>();
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Card> chanceDeck = new ArrayList<Card>();
	ArrayList<Card> communityDeck = new ArrayList<Card>();
	
	public void main(String[] args) {
		initialize();
	}
	
	public void initialize() {
		//board registry
		boardOrder.add(new boardSpaceGo(200));
		boardOrder.add(new boardSpaceProperty("Property 1", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {127, 127, 127}));
		boardOrder.add(new boardSpaceProperty("Property 2", new int[] {100, 200, 300, 400, 500, 600, 700, 800}, 500, new int[] {200, 200, 200}));
		//boardOrder.add(new boardSpaceUtilityElectricity("Electricity", new int[] {500, 1000}, 800}));
	}
	
	public void processTurn() {
		
	}
}