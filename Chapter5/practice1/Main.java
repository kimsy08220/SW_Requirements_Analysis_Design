package practice1;

public class Main {
	public static void main(String[] args) {
		System.out.println("Start.");
		
		for (int i = 0; i < 10; i++)
			System.out.println(i + " : " + TicketMaker.getInstance().getNextTicketNumber());	// �ν��Ͻ��� �ϳ��ۿ� �������� �ʴ´�.
		
		System.out.println("End.");
	}
}
