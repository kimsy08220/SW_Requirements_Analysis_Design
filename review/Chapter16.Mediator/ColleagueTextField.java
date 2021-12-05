import java.awt.*;
import java.awt.event.*;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
	private Mediator mediator;
	public ColleagueTextField(String text, int columns) {
		super(text, columns);
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		// enabled가 true이면 배경색 흰색, enabled가 false이면 배경색 회색
		setBackground(enabled ? Color.white : Color.lightGray);
	}
	public void textValueChanged(TextEvent e) {		// TextListener 메소드
		mediator.colleagueChanged();
		// 문자열이 변하면 Mediator에게 통지
	}
}
