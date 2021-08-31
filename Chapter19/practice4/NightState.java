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
		context.callSecurityCenter("비상:야간의 금고사용");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(야간)");
		context.changeState(UrgentState.getInstance());
	}
	public void doPhone(Context context) {
		context.recordLog("야갼의 통화 녹음");
	}
	public String toString() {
		return "[야간]";
	}
}