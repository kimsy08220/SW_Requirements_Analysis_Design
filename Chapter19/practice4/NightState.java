package practice4;

public class NightState implements State {
	private static NightState singleton = new NightState();
	private NightState() {}
	public static State getInstance() {
		return singleton;
	}
	public void doClock(Context context, int hour) {
		if (9 <= hour && hour < 17)
			context.changeState(DayState.getInstance());
	}
	public void doUse(Context context) {
		context.callSecurityCenter("���:�߰��� �ݰ���");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(�߰�)");
		context.changeState(UrgentState.getInstance());
	}
	public void doPhone(Context context) {
		context.recordLog("�߰��� ��ȭ ����");
	}
	public String toString() {
		return "[�߰�]";
	}
}