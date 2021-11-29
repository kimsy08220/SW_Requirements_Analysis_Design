
public class Hand {
	public static final int HANDVALUE_GUU = 0;	// 주먹
	public static final int HANDVALUE_CHO = 1;	// 가위
	public static final int HANDVALUE_PAA = 2;	// 보
	public static final Hand hand[] = {new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA)};	// hand는 가위바위보의 손을 나타내는 3개의 인스턴스를 가지고 있는 배열
	private static final String name[] = {"주먹", "가위", "보"};	// 가위바위보의 손의 문자열 표현
	private int handvalue;		// 가위바위보의 손의 값
	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h) {		// this가 h보다 강할 때 true
		return fight(h) == 1;
	}
	public boolean isWeakerThan(Hand h) {		// this가 h보다 약할 때 true
		return fight(h) == -1;
	}
	private int fight(Hand h) {
		if (this.handvalue == h.handvalue)
			return 0;
		else if ((this.handvalue + 1) % 3 == h.handvalue)
			return 1;
		else 
			return -1;
	}
	public String toString() {
		return name[handvalue];
	}
}
