package practice2;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	private String name;
	private Vector dir = new Vector();
	public Directory(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getSize() {
		SizeVisitor v = new SizeVisitor();
		accept(v);
		return v.getSize();
	}
	public Entry add(Entry entry) {
		dir.add(entry);
		return this;
	}
	public Iterator iterator() {
		return dir.iterator();
	}
	public void accept(Visitor v) {
		v.visit(this);
	}
}
