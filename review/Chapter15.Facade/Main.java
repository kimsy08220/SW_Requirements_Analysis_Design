import pagemaker.PageMaker;

public class Main {
	public static void main(String[] args) {
		// Main�� main() �޼ҵ�� Database�� HtmlWriter�� �޼ҵ带 ���� ������� �ʰ�, 
		//facade ����(high-level API�� ����)�� �ϴ� PageMaker�� makeWelcomPage() �޼ҵ常�� ����ؼ� ���ϴ� ���� ����
		PageMaker.makeWelcomePage("youngjin@youngjin.com", "welcome.html");
	}
}
