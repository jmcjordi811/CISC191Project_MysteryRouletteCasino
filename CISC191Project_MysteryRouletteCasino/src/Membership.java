
public interface Membership {
	public int points = 0;
	
	public Player [] members = {new Player("Jordi"), new Player("Emily"),
									new Player("Gabriel"), new Player("Yailine"),
									new Player("David"), new Player("Mayra")};
	
	public void addPoints();
}
