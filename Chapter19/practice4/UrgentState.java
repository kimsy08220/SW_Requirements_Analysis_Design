package practice4;

public class UrgentState implements State {
	private static UrgentState singleton = new UrgentState();
	private UrgentState() {}
	public static State getInstance() {
		return singleton;
	}
	public void doClock(Context context, int hour) {
		// �ð� ���������� �ƹ� ó���� ���� �ʴ´�.
	}
	public void doUse(Context context) {
		context.callSecurityCenter("���:������ �ݰ���!");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(������)");	
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("�Ϲ���ȭ(������)");
	}
	public String toString() {
		return "[������]";
	}
}