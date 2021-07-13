
public class Player {
	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;
	public Player(String name, Strategy strategy) {	// 이름과 전략을 인자로 전달받음
		this.name = name;
		this.strategy = strategy;
	}
	public Hand nextHand() {				// 전략의 지시를 받음
		return strategy.nextHand();
	}
	public void win() {						// 이겼을 때 호출되는 메소드
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	public void lose() {					// 졌을 때 호출되는 메소드
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	public void even() {					// 비겼을 때 호출되는 메소드
		gamecount++;
	}
	public String toString() {
		return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + "lose]";
	}
}
