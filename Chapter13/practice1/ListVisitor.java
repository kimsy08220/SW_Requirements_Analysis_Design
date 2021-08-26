package practice1;

import java.util.Iterator;

public class ListVisitor extends Visitor {
	private String currentdir = "";		// �湮 ���� ���丮�� ��θ�
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;	// �湮 ���� ���丮 ������ ����� ��θ�
		currentdir = currentdir + "/" + directory.getName();
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		currentdir = savedir;
	}
}