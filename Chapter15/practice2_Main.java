import practice2_pagemaker.PageMaker;

public class practice2_Main {
	public static void main(String[] args) {
		// Main의 main() 메소드는 Database나 HtmlWriter의 메소드를 직접 사용하지 않고, 
		//facade 역할(high-level API를 제공)을 하는 PageMaker의 makeWelcomPage() 메소드만을 사용해서 원하는 일을 수행
		PageMaker.makeLinkPage("linkPage.html");
	}
}