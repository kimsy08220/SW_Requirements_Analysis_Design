package game;

import java.util.Vector;

public class Memento {
	int money;
	Vector fruits;
	// 생성자에 public이 없음 => package 접근 권한 <<wide interface>>
	// 같은 패키지에 속하는 클래스에서만 호출할 수 있음
	Memento(int money) {
		this.money = money;
		this.fruits = new Vector();
	}
	// package 접근 권한 <<wide interface>>
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	
	// <<narrow interface>>
	public int getMoney() {
		return money;
	}
}
