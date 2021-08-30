package practice4_game;

import java.util.*;
import java.io.*;

public class Memento implements Serializable {
	int money;			// ������	
	ArrayList fruits;	// ����
	// �������� ���� (narrow interface)
	public int getMoney() {
		return money;
	}
	// ������ (wide interface)
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList();
	}
	// ������ �߰� (wide interface)
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	// ������ ���� (wide interface)
	List getFruits() {
		return (List)fruits.clone();
	}
}
