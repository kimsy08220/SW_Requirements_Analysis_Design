package practice4;

import java.awt.*;
import java.awt.event.*;

public class SafeFrame extends Frame implements ActionListener, Context {
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("금고사용");
	private Button buttonAlarm = new Button("비상벨");
	private Button buttonPhone = new Button("일반 통화");
	private Button buttonExit = new Button("종료");
	private State state = DayState.getInstance();
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);			// 배경색 설정
		setLayout(new BorderLayout());			// 레이아웃 매니저 설정
		
		// textClock 배치
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		
		// textScreen 배치
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		
		// 패널에 버튼 추가
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		
		// 패널 배치
		add(panel, BorderLayout.SOUTH);
		
		// 표시
		pack();
		setVisible(true);
		
		// 리스너 설정
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("" + e);
		
		if (e.getSource() == buttonUse)			// 금고사용 버튼이 눌러지면...
			state.doUse(this);
		else if (e.getSource() == buttonAlarm)	// 비상벨 버튼이 눌러지면...
			state.doAlarm(this);
		else if (e.getSource() == buttonPhone)	// 일반 통화 버튼이 눌러지면...
			state.doPhone(this);
		else if (e.getSource() == buttonExit)	// 종료 버튼이 눌러지면...
			System.exit(0);
		else
			System.out.println("?");
	}
	public void setClock(int hour) {
		String clockstring = "현재 시각은";
		
		if (hour < 10) 
			clockstring += "0" + hour + ":00";
		else
			clockstring += hour + ":00";
		
		System.out.println(clockstring);
		textClock.setText(clockstring);
		state.doClock(this, hour);
	}
	public void changeState(State state) {
		System.out.println(this.state + "에서" + state + "로 상태가 변화했습니다.");
		this.state = state;
	}
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}
}
