package listfactory;

import factory.*;
import java.util.Iterator;

public class ListPage extends Page {
	public ListPage(String title, String author) {
		super(title, author);
	}
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		// HTML 페이지의 초반부를 만듦
		buffer.append("<html><head><title>" + title + "</title></head>\n");
		buffer.append("<body>\n");
		buffer.append("<h1>" + title + "</h1>\n");
		buffer.append("<ul>\n");
		
		// 자기가 포함하고 있는 모든 부품의 makeHTML()을 호출
		Iterator it = content.iterator();
		while (it.hasNext()) {
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		
		// HTML 페이지의 마지막 부분을 만듦
		buffer.append("</ul>\n");
		buffer.append("<hr><address>" + author + "</address>");
		buffer.append("</body></html>\n");
		return buffer.toString();
	}
}
