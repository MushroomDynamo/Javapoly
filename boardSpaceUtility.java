public class boardSpaceUtility extends boardSpace {
	Player owner;
	String title = new String();
	int price;
	int[] rentData; //size 2, enforce
	public boardSpaceUtility(String newTitle, int[] newRentData, int newPrice) {
		setTitle(newTitle);
		setRentData(newRentData);
		setPrice(newPrice);
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	public void setRentData(int[] newRentData) {
		rentData = newRentData.clone();
	}
	public void setPrice(int newPrice) {
		price = newPrice;
	}
	public void setOwner(Player newPlayer) {
		owner = newPlayer;
	}
	public String getTitle() {
		return title;
	}
	public int[] getRentData() {
		return rentData;
	}
	public int getPrice() {
		return price;
	}
	public Player getOwner() {
		return owner;
	}
}