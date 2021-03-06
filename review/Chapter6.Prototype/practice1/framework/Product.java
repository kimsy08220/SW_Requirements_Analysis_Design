package practice1.framework;

import java.lang.Cloneable;

public abstract class Product implements Cloneable {
	public abstract void use(String s);
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}
