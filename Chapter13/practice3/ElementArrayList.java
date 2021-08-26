package practice3;

import java.util.Iterator;
import java.util.ArrayList;

public class ElementArrayList extends ArrayList implements Element {
	public void accept(Visitor v) {
		Iterator it = iterator();
		while (it.hasNext()) {
			Element a = (Element)it.next();
			a.accept(v);
		}
	}
}
