import game.*;
import java.io.*;

// 수정 요청...

public class practice4_Main {
	public static final String SAVEFILENAME = "game.dat";
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento memento = loadMemento();
		
		if (memento != null) {
			System.out.println("지난번 저장한 결과에서 시작합니다.");
			gamer.restoreMemento(memento);
		}
		else {
			System.out.println("새로 시작합니다.");
			memento = gamer.createMemento();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("==== " + i);
			System.out.println("현상 : " + gamer);
			
			gamer.bet();
			
			System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");
			
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("  (많이 증가했으므로 현재의 상태를 저장하자)");
				memento = gamer.createMemento();
				saveMemento(memento);
			}
			else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("  (많이 감소했으므로 이전의 상태로 복원하자)");
				gamer.restoreMemento(memento);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println();
		}
	}
	public static void saveMemento(Memento memento) {
		try {
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SAVEFILENAME));
			out.writeObject(memento);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Memento loadMemento() {
		Memento memento = null;
		try {
			ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME));
			memento = (Memento)in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memento;
	}
}