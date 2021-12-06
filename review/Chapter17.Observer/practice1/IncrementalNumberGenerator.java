package practice1;

import java.util.Random;

public class IncrementalNumberGenerator extends NumberGenerator {
	private int number, end, inc;
	public IncrementalNumberGenerator(int start, int end, int inc) {
		this.number = start;
		this.end = end;
		this.inc = inc;
	}
	public int getNumber() {
		return number;
	}
	public void execute() {		// ���°� ���ߴٴ� ���� ��
		while (number < end) {
			notifyObservers();
			number += inc;
		}
	}
}
