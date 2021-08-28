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
		// enabled�� true�̸� ���� ���, enabled�� false�̸� ���� ȸ��
		setBackground(enabled ? Color.white : Color.lightGray);
	}
	public void textValueChanged(TextEvent e) {		// TextListener �޼ҵ�
		mediator.colleagueChanged();
		// ���ڿ��� ���ϸ� Mediator���� ����
	}
}
