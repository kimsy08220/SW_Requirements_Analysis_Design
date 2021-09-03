import practice3_command.*;
import practice3_drawer.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice3_Main extends JFrame implements ActionListener {
	private MacroCommand history = new MacroCommand();
	// Main과 DrawCanvas 인스턴스가 history를 공유
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
				Command cmd = new DrawCommand(canvas, e.getPoint());	// Client 역할
				history.append(cmd);
				cmd.execute();											// Invoker 역할
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
			canvas.repaint();		// paint()를 호출하며 비워진 history의 execute()를 호출하게 됨
		}
	}
	
	public static void main(String[] args) {
		new practice3_Main("Command Pattern Sample");
	}
}
