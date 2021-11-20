
public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	public final void display() {	// 하위 클래스에서 오버라이딩 할 수 없다는 의미
		open();
		for (int i = 0; i < 5; i++)
			print();
		close();
	}
}
