import practice1.framework.*;

public class practice1_Main {
	public static void main(String[] args) {
		Manager manager = new Manager();
		practice1_UnderlinePen upen = new practice1_UnderlinePen('~');
		practice1_MessageBox mbox = new practice1_MessageBox('*');
		practice1_MessageBox sbox = new practice1_MessageBox('/');
		
		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		
		Product p1 = manager.create("strong message");
		p1.use("Hello, world.");
		Product p2 = manager.create("warning box");
		p2.use("Hello, world.");
		Product p3 = manager.create("slash box");
		p3.use("Hello, world.");
	}
}
