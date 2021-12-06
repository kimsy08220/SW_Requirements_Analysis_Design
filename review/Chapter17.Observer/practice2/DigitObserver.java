package practice2;

public class DigitObserver implements Observer {
	public void update(NumberGenerator generator) {
		System.out.println("DigitObserver : " + generator.getNumber());
		try {
			Thread.sleep(100);		// (100/1000 = 0.1��) ���� CPU�� ��ȯ
		} catch (InterruptedException e) {}
	}
}
