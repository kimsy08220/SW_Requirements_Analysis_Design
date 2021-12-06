
public class GraphObserver implements Observer {
	public void update(NumberGenerator generator) {
		System.out.print("GraphObserver : ");
		int count = generator.getNumber();
		for (int i = 0; i < count; i++)
			System.out.print("*");
		System.out.println();
		try {
			Thread.sleep(100);		// (100/1000 = 0.1초) 동안 CPU를 반환
		} catch (InterruptedException e) {}
	}
}
