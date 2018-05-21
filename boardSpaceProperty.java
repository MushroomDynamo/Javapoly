public class boardSpaceProperty extends boardSpace {
	Player owner;
	int[] rentData; //should be size 8, investigate enforcing this
	int price;
	int[] rgb;
	
	public boardSpaceProperty(String newTitle, int[] newRentData, int newPrice, int[] newRGB) {
		setTitle(newTitle);
		setRentData(newRentData);
		setPrice(newPrice);
		setRGB(newRGB);
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
	public void setRGB(int[] newRGB) {
		rgb = newRGB.clone();
	}
	public void setOwner(Player player) {
		owner = player;
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
	public int[] getRGB() {
		return rgb;
	}
	public Player getOwner() {
		return owner;
	}
}