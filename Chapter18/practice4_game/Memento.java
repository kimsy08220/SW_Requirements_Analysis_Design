package practice4_game;

import java.util.*;
import java.io.*;

public class Memento implements Serializable {
	int money;			// 소지금	
	ArrayList fruits;	// 과일
	// 소지금을 얻음 (narrow interface)
	public int getMoney() {
		return money;
	}
	// 생성자 (wide interface)
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList();
	}
	// 과일을 추가 (wide interface)
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	// 과일을 얻음 (wide interface)
	List getFruits() {
		return (List)fruits.clone();
	}
}
