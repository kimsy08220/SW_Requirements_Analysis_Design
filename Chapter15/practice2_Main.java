import practice2_pagemaker.PageMaker;

public class practice2_Main {
	public static void main(String[] args) {
		// Main�� main() �޼ҵ�� Database�� HtmlWriter�� �޼ҵ带 ���� ������� �ʰ�, 
		//facade ����(high-level API�� ����)�� �ϴ� PageMaker�� makeWelcomPage() �޼ҵ常�� ����ؼ� ���ϴ� ���� ����
		PageMaker.makeLinkPage("linkPage.html");
	}
}