public class boardSpaceUtility implements boardSpace {
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
	public String getTitle() {
		return title;
	}
	public int[] getRentData() {
		return rentData;
	}
	public int getPrice() {
		return price;
	}
}