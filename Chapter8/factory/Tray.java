package factory;

import java.util.Vector;

public abstract class Tray extends Item {
	protected Vector tray = new Vector();
	public Tray(String caption) {
		super(caption);
	}
	
	// Item�� ��ӹ��� Link�� Tray�� ��� �Է� ���ڷ� �޾Ƶ��� �� ����
	public void add(Item item) {
		tray.add(item);
	}
}
