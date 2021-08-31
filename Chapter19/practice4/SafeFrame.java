package practice4;

import java.awt.*;
import java.awt.event.*;

public class SafeFrame extends Frame implements ActionListener, Context {
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("�ݰ���");
	private Button buttonAlarm = new Button("���");
	private Button buttonPhone = new Button("�Ϲ� ��ȭ");
	private Button buttonExit = new Button("����");
	private State state = DayState.getInstance();
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);			// ���� ����
		setLayout(new BorderLayout());			// ���̾ƿ� �Ŵ��� ����
		
		// textClock ��ġ
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		
		// textScreen ��ġ
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		
		// �гο� ��ư �߰�
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		
		// �г� ��ġ
		add(panel, BorderLayout.SOUTH);
		
		// ǥ��
		pack();
		setVisible(true);
		
		// ������ ����
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("" + e);
		
		if (e.getSource() == buttonUse)			// �ݰ��� ��ư�� ��������...
			state.doUse(this);
		else if (e.getSource() == buttonAlarm)	// ��� ��ư�� ��������...
			state.doAlarm(this);
		else if (e.getSource() == buttonPhone)	// �Ϲ� ��ȭ ��ư�� ��������...
			state.doPhone(this);
		else if (e.getSource() == buttonExit)	// ���� ��ư�� ��������...
			System.exit(0);
		else
			System.out.println("?");
	}
	public void setClock(int hour) {
		String clockstring = "���� �ð���";
		
		if (hour < 10) 
			clockstring += "0" + hour + ":00";
		else
			clockstring += hour + ":00";
		
		System.out.println(clockstring);
		textClock.setText(clockstring);
		state.doClock(this, hour);
	}
	public void changeState(State state) {
		System.out.println(this.state + "����" + state + "�� ���°� ��ȭ�߽��ϴ�.");
		this.state = state;
	}
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}
}
