package factory;

import java.util.Vector;

public abstract class Tray extends Item {
	protected Vector tray = new Vector();
	public Tray(String caption) {
		super(caption);
	}
	
	// Item을 상속받은 Link나 Tray를 모두 입력 인자로 받아들일 수 있음
	public void add(Item item) {
		tray.add(item);
	}
}
