
public class Hand {
	public static final int HANDVALUE_GUU = 0;	// �ָ�
	public static final int HANDVALUE_CHO = 1;	// ����
	public static final int HANDVALUE_PAA = 2;	// ��
	public static final Hand hand[] = {new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA)};	// hand�� ������������ ���� ��Ÿ���� 3���� �ν��Ͻ��� ������ �ִ� �迭
	private static final String name[] = {"�ָ�", "����", "��"};	// ������������ ���� ���ڿ� ǥ��
	private int handvalue;		// ������������ ���� ��
	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h) {		// this�� h���� ���� �� true
		return fight(h) == 1;
	}
	public boolean isWeakerThan(Hand h) {		// this�� h���� ���� �� true
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
