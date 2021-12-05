import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	// Colleague들을 생성하고 배치한 후에 표시를 실행
	public LoginFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		// 레이아웃 매니저를 사용해서 4x2의 그리드를 생성
		setLayout(new GridLayout(4, 2));
		// Colleague들의 생성
		createColleagues();
		// 배치
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username : "));
		add(textUser);
		add(new Label("Password : "));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// 유효/무효의 초기 지정
		colleagueChanged();
		// 표시
		pack();
		setVisible(true);
	}

	// Colleague들을 생성
	public void createColleagues() {
		// 생성
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		// Mediator의 세트
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonOk.setMediator(this);
		// Listener의 세트
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// Colleage에서의 통지로 Colleage의 유효/무효를 판정
	public void colleagueChanged() {
		if (checkGuest.getState()) { 				// Guest 모드
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		} 
		else { 									// Login 모드
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	// TextField 상태 변화에 따라 Colleague를 활성화/비활성화함
	private void userpassChanged() {
		if (textUser.getText().length() > 0) { 			// textUser에 값이 들어가 있다면
			textPass.setColleagueEnabled(true); 		// textPass를 활성화
			if (textPass.getText().length() > 0) 		// textPass에 값이 들어가 있다면
				buttonOk.setColleagueEnabled(true); 	// buttonOk를 활성화
			else
				buttonOk.setColleagueEnabled(false);
		} 
		else { 		// textUser에 값이 들어가 있지 않다면 textPass와 buttonOk를 비활성화
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}
}
