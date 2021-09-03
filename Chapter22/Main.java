import command.*;
import drawer.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
	private MacroCommand history = new MacroCommand();
	// Main�� DrawCanvas �ν��Ͻ��� history�� ����
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton clearButton = new JButton("clear");
	
	public Main(String title) {
		super(title);
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
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
	public void mouseMoved(MouseEvent e) {}		// MouseMotionListener �������̽�
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());	// Client ����
		history.append(cmd);
		cmd.execute();											// Invoker ����
	}
	public void windowClosing(WindowEvent e) {	// WindowListener �������̽�
		System.exit(0);
	} 
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}
