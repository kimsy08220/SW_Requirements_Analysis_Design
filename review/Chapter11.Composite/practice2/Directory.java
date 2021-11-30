package practice2;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	private String name;
	private Vector directory = new Vector();	// ���丮 ��Ʈ�� ����
	public Directory(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getSize() {
		int size = 0;
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			size += entry.getSize();
		}
		return size;
	}
	public Entry add(Entry entry) {
		directory.add(entry);
		entry.parent = this;
		return this;
	}
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);	
		// �ڽ��� ������ �ִ� ��� ��Ʈ���� ���ؼ� printList() ȣ��
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.printList(prefix + "/" + name);
		}
	}
}
