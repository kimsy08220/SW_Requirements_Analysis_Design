package practice1;

public interface Strategy {
	public abstract Hand nextHand();			// 다음에 내밀 손을 알려줌
	public abstract void study(boolean win);	// 내밀 손을 결정하는데 필요한 정보를 처리
}
