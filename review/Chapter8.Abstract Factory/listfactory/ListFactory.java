package listfactory;

import factory.*;

// 구체적인 부품과 제품을 생산하여 반환하는 공장
public class ListFactory extends Factory {
	public Link createLink(String caption, String url) {
		return new ListLink(caption, url);
	}
	public Tray createTray(String caption) {
		return new ListTray(caption);
	}
	public Page createPage(String title, String author) {
		return new ListPage(title, author);
	}
}
