package factory;

import java.io.*;
import java.util.Vector;

public abstract class Page {
	protected String title;
	protected String author;
	protected Vector content = new Vector();
	
	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	// Item을 상속받은 Link나 Tray를 모두 입력 인자로 받아들일 수 있음
	public void add(Item item) {
		content.add(item);
	}
	public void output() {
		try {
			String filename = title + ".html";
			Writer writer = new FileWriter(filename);
			writer.write(this.makeHTML());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public abstract String makeHTML();
}
