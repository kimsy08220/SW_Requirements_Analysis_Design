package practice2;

public class Main {
	public static void main(String[] args) {
		CountDisplay d = new CountDisplay(new FileDisplayImpl("start.txt"));
		d.multiDisplay(3);
	}
}
