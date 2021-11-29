import java.util.Random;

public class WinningStrategy implements Strategy {
	private Random random;
	private boolean won = false;		// 초기화를 안 해주게 되면 자동으로 false로 초기화
	private Hand prevHand;
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	public Hand nextHand() {
		if (!won)	// 직전에 졌을 경우
			prevHand = Hand.getHand(random.nextInt(3));	// 새로운 손을 얻음
		return prevHand;	// 이겼을 경우, 직전 손이 그대로 반환
	}
	public void study(boolean win) {
		won = win;			// 지난번 승부를 저장
	}
}
