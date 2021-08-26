package practice1;

import java.util.Iterator;

public class ListVisitor extends Visitor {
	private String currentdir = "";		// 방문 중인 디렉토리의 경로명
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;	// 방문 중인 디렉토리 복원시 사용할 경로명
		currentdir = currentdir + "/" + directory.getName();
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		currentdir = savedir;
	}
}