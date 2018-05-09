public class boardSpaceGo extends boardSpace {
	int award;
	public boardSpaceGo(int newaward) {
		setAward(newaward);
	}
	public void setAward(int newaward) {
		award = newaward;
	}
	public int getAward() {
		return award;
	}
}