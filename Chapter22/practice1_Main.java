import practice1_command.*;
import practice1_drawer.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice1_Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
	private MacroCommand history = new MacroCommand();
	// Main과 DrawCanvas 인스턴스가 history를 공유
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton clearButton = new JButton("clear");
	private JButton redButton = new JButton("red");
	private JButton greenButton = new JButton("green");
	private JButton blueButton = new JButton("blue");
	
	public practice1_Main(String title) {
		super(title);
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
		blueButton.addActionListener(this);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		buttonBox.add(redButton);
		buttonBox.add(greenButton);
		buttonBox.add(blueButton);
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
			canvas.init();
			canvas.repaint();		// paint()를 호출하며 비워진 history의 execute()를 호출하게 됨
		}
		else if (e.getSource() == redButton) {
			Command cmd = new ColorCommand(canvas, Color.red);
			history.append(cmd);
			cmd.execute();
		}
		else if (e.getSource() == greenButton) {
			Command cmd = new ColorCommand(canvas, Color.green);
			history.append(cmd);
			cmd.execute();
		}
		else if (e.getSource() == blueButton) {
			Command cmd = new ColorCommand(canvas, Color.blue);
			history.append(cmd);
			cmd.execute();
		}
	}
	public void mouseMoved(MouseEvent e) {}		// MouseMotionListener 인터페이스
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());	// Client 역할
		history.append(cmd);
		cmd.execute();											// Invoker 역할
	}
	public void windowClosing(WindowEvent e) {	// WindowListener 인터페이스
		System.exit(0);
	} 
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
	public static void main(String[] args) {
		new practice1_Main("Command Pattern Sample");
	}
}