package practice1;

import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor {
	private String filetype;
	private ArrayList found = new ArrayList();
	
	public FileFindVisitor(String filetype) {		// ".txt"와 같이 확장자에 .을 붙여 지정
		this.filetype = filetype;
	}
	public Iterator getFoundFiles() {				// 발견한 파일을 얻음
		return found.iterator();
	}
	public void visit(File file) {					// 파일을 방문할 때 호출
		if (file.getName().endsWith(filetype))		// 파일의 이름과 filetype이 같은지 검사
			found.add(file);
	}
	public void visit(Directory directory) {		// 디렉터리를 방문할 때 호출
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
}
