import practice3_command.*;
import practice3_drawer.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice3_Main extends JFrame implements ActionListener {
	private MacroCommand history = new MacroCommand();
	// Main�� DrawCanvas �ν��Ͻ��� history�� ����
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton clearButton = new JButton("clear");
	
	public practice3_Main(String title) {
		super(title);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Command cmd = new DrawCommand(canvas, e.getPoint());	// Client ����
				history.append(cmd);
				cmd.execute();											// Invoker ����
			}
		});
		clearButton.addActionListener(this);
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();		// paint()�� ȣ���ϸ� ����� history�� execute()�� ȣ���ϰ� ��
		}
	}
	
	public static void main(String[] args) {
		new practice3_Main("Command Pattern Sample");
	}
}
