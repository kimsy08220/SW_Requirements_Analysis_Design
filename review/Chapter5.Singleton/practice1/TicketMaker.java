package practice1;

public class TicketMaker {
	private static TicketMaker singleton = new TicketMaker();
	private int ticket = 1000;
	
	private TicketMaker() {}
	public static TicketMaker getInstance() {
		return singleton;
	}
	public int getNextTicketNumber() {
		return ticket++;
	}
}
