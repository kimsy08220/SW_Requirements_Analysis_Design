import practice1.framework.*;

public class practice1_UnderlinePen extends Product {
	private char ulchar;
	public practice1_UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}
	public void use(String s) {
		int length = s.getBytes().length;
		System.out.println("\"" + s + "\""); 
		System.out.print(" "); 
		for (int i = 0; i < length; i++)
			System.out.print(ulchar);
		System.out.println(); 
	}
}
