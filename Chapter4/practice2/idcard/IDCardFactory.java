package practice2.idcard;

import practice2.framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
	private HashMap database = new HashMap();
	private int serial = 100;
	
	protected synchronized Product createProduct(String owner) {		// synchronized ���� ����
		return new IDCard(owner, serial++);
	}
	protected void registerProduct(Product product) {
		IDCard card = (IDCard)product;
		database.put(card.getSerial(), card.getOwner());
	}
	public HashMap getDatabase() {
		return database;
	}
}
