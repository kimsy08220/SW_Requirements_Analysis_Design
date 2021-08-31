package practice3;

public class NoonState implements State {
	private static NoonState singleton = new NoonState();
	private NoonState() {}
	public static State getInstance() {
		return singleton;
	}
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour)
			context.changeState(NightState.getInstance());
		else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17)
			context.changeState(DayState.getInstance());
	}
	public void doUse(Context context) {
		context.callSecurityCenter("���:���ɽð� �ݰ���");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(���ɽð�)");	
	}
	public void doPhone(Context context) {
		context.recordLog("���ɽð� ��ȭ ����");
	}
	public String toString() {
		return "[���ɽð�]";
	}
}