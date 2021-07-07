package 위임;

public class PrintBanner extends Print{
	private Banner banner;
	public PrintBanner(String string) {
		this.banner = new Banner(string);
	}
	public void printWeak() {		// 위임
		banner.showWithParen();
	}
	public void printStrong() {		// 위임
		banner.showWithAster();
	}
}
