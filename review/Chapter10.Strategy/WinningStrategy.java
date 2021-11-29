import java.util.Random;

public class WinningStrategy implements Strategy {
	private Random random;
	private boolean won = false;		// �ʱ�ȭ�� �� ���ְ� �Ǹ� �ڵ����� false�� �ʱ�ȭ
	private Hand prevHand;
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	public Hand nextHand() {
		if (!won)	// ������ ���� ���
			prevHand = Hand.getHand(random.nextInt(3));	// ���ο� ���� ����
		return prevHand;	// �̰��� ���, ���� ���� �״�� ��ȯ
	}
	public void study(boolean win) {
		won = win;			// ������ �ºθ� ����
	}
}
