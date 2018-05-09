import java.lang.Math;

public abstract class Card {
	int id;
	
	public Card(int deckMax) {
		id = (int) Math.floor(Math.random() * deckMax); //Current deck size. TODO configurable
	}
	
	public int getId() {
		return id;
	}
	
	//Categorize cards based on their operating parameters to cut down on methods
}