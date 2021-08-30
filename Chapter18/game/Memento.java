package game;

import java.util.Vector;

public class Memento {
	int money;
	Vector fruits;
	// �����ڿ� public�� ���� => package ���� ���� <<wide interface>>
	// ���� ��Ű���� ���ϴ� Ŭ���������� ȣ���� �� ����
	Memento(int money) {
		this.money = money;
		this.fruits = new Vector();
	}
	// package ���� ���� <<wide interface>>
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	
	// <<narrow interface>>
	public int getMoney() {
		return money;
	}
}
