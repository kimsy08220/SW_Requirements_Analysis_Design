import java.util.Random;

public class ProbStrategy implements Strategy {
	private Random random;
	private int prevHandValue = 0;
	private int currentHandValue = 0;
	private int history[][] = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
	public ProbStrategy(int seed) {
		random = new Random(seed);
	}
	public Hand nextHand() {
		int bet = random.nextInt(getSum(currentHandValue));  // 현재 손을 낸 후 이긴 총 횟수를 이용해서 난수를 얻음
		int handvalue = 0;
		if (bet < history[currentHandValue][0])
			handvalue = 0;		// 주먹
		else if (bet < history[currentHandValue][0] + history[currentHandValue][1])
			handvalue = 1;		// 가위
		else
			handvalue = 2;		// 보
		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	}
	private int getSum(int hv) {		// hv를 낸 후 이긴 총 횟수를 반환
		int sum = 0;
		for (int i = 0; i < 3; i++)
			sum += history[hv][i];
		return sum;
	}
	public void study(boolean win) {
		if (win)	// 이겼을 경우, 이번에 냈던 손에 1을 더함
			history[prevHandValue][currentHandValue]++;
		else {		// 졌을 경우, 이번에 내지 않았던 두 손에 1을 더함
			history[prevHandValue][(currentHandValue + 1) % 3]++;
			history[prevHandValue][(currentHandValue + 2) % 3]++;
		}
	}
}
