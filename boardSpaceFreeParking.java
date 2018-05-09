public class boardSpaceFreeParking extends boardSpace {
	int fundsPot;
	public boardSpaceFreeParking(int newFundsPot) {
		setFundsPot(newFundsPot);
	}
	public void setFundsPot(int newFundsPot) {
		fundsPot = newFundsPot;
	}
	public int getFundsPot() {
		return fundsPot;
	}
}