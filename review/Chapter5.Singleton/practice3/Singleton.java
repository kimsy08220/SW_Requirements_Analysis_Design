package practice3;

public class Singleton {
	private static Singleton singleton = null;
	private Singleton() {
		System.out.println("인스턴스를 생성했습니다.");
		slowdown();
	}
	public static synchronized Singleton getInstance() {	// synchronized : 하나의 객체만 생성(객체 동일)
		if (singleton == null)
			singleton = new Singleton();
		return singleton;
	}
	private void slowdown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
}
