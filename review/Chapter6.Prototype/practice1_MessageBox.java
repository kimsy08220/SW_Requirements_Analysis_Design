import practice1.framework.*;

public class practice1_MessageBox extends Product {
	private char decochar;
	public practice1_MessageBox(char decochar) {
		this.decochar = decochar;
	}
	public void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++)
			System.out.print(decochar);
		System.out.println();
		System.out.println(decochar + " " + s + " " + decochar); 
		for (int i = 0; i < length + 4; i++)
			System.out.print(decochar);
		System.out.println();
	}
}
