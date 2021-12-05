package practice1;

import java.awt.*;
import java.awt.event.*;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
	private Mediator mediator;
	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
		super(caption, group, state);
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}
	public void itemStateChanged(ItemEvent e) {		// ItemListener
		mediator.colleagueChanged();
		// ���°� ���ϸ� Mediator���� ����
	}
}