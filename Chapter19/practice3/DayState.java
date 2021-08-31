package practice3;

public class DayState implements State {
	private static DayState singleton = new DayState();
	private DayState() {}
	// 하나의 상태만 필요하므로 Singleton 패턴 사용
	public static State getInstance() {
		return singleton;
	}
	// 시각 설정시 호출
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour)
			context.changeState(NightState.getInstance());
		else if (12 <= hour && hour < 13)
			context.changeState(NoonState.getInstance());
	}
	public void doUse(Context context) {
		context.recordLog("금고사용(주간)");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(주간)");	
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("일반 통화(주간)");
	}
	public String toString() {
		return "[주간]";
	}
}