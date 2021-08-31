package practice3;

public class DayState implements State {
	private static DayState singleton = new DayState();
	private DayState() {}
	// �ϳ��� ���¸� �ʿ��ϹǷ� Singleton ���� ���
	public static State getInstance() {
		return singleton;
	}
	// �ð� ������ ȣ��
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour)
			context.changeState(NightState.getInstance());
		else if (12 <= hour && hour < 13)
			context.changeState(NoonState.getInstance());
	}
	public void doUse(Context context) {
		context.recordLog("�ݰ���(�ְ�)");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(�ְ�)");	
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("�Ϲ� ��ȭ(�ְ�)");
	}
	public String toString() {
		return "[�ְ�]";
	}
}