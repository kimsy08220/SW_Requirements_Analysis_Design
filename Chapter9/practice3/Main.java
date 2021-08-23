package practice3;

public class Main {
	public static void main(String[] args) {
		IncreaseDisplay d1 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
		IncreaseDisplay d2 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
		d1.increaseDiplay(4);
		d2.increaseDiplay(6);
	}
}
