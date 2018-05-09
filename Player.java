import java.util.ArrayList;
import java.lang.Integer;

public class Player {
	Boolean isHuman;
	Boolean inJail = false;
	int funds;
	int jailFreeCards = 0;
	boardSpace position;
	ArrayList<Integer[]> rollHistory = new ArrayList<Integer[]>(2);
	
	public Player(int newFunds, boardSpace newPosition) {
		setFunds(newFunds);
		setPosition(newPosition);
	}
	
	public void setIsHuman(Boolean state) {
		isHuman = state;
	}
	public void setInJail(Boolean state) {
		inJail = state;
	}
	public void setFunds(int newFunds) { //TODO add increment/decrement methods, or modify this method to offer them
		funds = newFunds;
	}
	public void setJailFreeCards(int newJailFreeCards) {
		jailFreeCards = newJailFreeCards;
	}
	public void setPosition(boardSpace newPosition) {
		position = newPosition;
	}
	
	public Boolean getIsHuman() {
		return isHuman;
	}
	public Boolean getInJail() {
		return inJail;
	}
	public int getFunds() {
		return funds;
	}
	public int getJailFreeCards() {
		return jailFreeCards;
	}
	public boardSpace getPosition() {
		return position;
	}
}