package practice1;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
	private Mediator mediator;
	public ColleagueButton(String caption) {
		super(caption);
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void setColleagueEnabled(boolean enabled) {
		//setEnabled()는 부모인 Button 클래스로부터 물려받은 메소드
		setEnabled(enabled);
	}
}