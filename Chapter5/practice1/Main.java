package practice1;

public class Main {
	public static void main(String[] args) {
		System.out.println("Start.");
		
		for (int i = 0; i < 10; i++)
			System.out.println(i + " : " + TicketMaker.getInstance().getNextTicketNumber());	// 인스턴스는 하나밖에 생성되지 않는다.
		
		System.out.println("End.");
	}
}
