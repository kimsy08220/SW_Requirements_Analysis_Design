package practice1_drawer;

import java.awt.Color;
import practice1_command.Command;

public class ColorCommand implements Command {
	// �׸� �׸��� ���
	protected Drawable drawable;
	// �׸� �׸��� ��
	private Color color;
	
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;
	}
	public void execute() {
		drawable.setColor(color);
	}
}