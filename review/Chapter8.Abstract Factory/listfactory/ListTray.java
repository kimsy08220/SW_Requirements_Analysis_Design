package listfactory;

import factory.*;
import java.util.Iterator;

public class ListTray extends Tray {
	public ListTray(String caption) {
		super(caption);
	}
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<li>\n");
		buffer.append(caption + "\n");
		buffer.append("<ul>\n");	// <ul> : unordered list의 약자
		// tray는 부품들을 담고 있는 벡터 타입의 필드
		
		Iterator it = tray.iterator();
		// 자기가 포함하고 있는 모든 부품의 makeHTML()을 호출
		while (it.hasNext()) {
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		return buffer.toString();
	}
}
