package practice1;

import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor {
	private String filetype;
	private ArrayList found = new ArrayList();
	
	public FileFindVisitor(String filetype) {		// ".txt"�� ���� Ȯ���ڿ� .�� �ٿ� ����
		this.filetype = filetype;
	}
	public Iterator getFoundFiles() {				// �߰��� ������ ����
		return found.iterator();
	}
	public void visit(File file) {					// ������ �湮�� �� ȣ��
		if (file.getName().endsWith(filetype))		// ������ �̸��� filetype�� ������ �˻�
			found.add(file);
	}
	public void visit(Directory directory) {		// ���͸��� �湮�� �� ȣ��
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
}
