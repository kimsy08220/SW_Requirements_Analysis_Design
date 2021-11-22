package practice2.idcard;

import practice2.framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
	private Vector owners = new Vector();
	private int serial = 1000;
	protected Product createProduct(String owner) {
		return new IDCard(owner, serial++);
	}
	protected void registerProduct(Product product) {
		owners.add(((IDCard)product).getOwner());
	}
	public Vector getOwners() {
		return owners;
	}
}
