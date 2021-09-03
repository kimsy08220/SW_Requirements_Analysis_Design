package practice1_drawer;

import java.awt.Color;
import practice1_command.Command;

public class ColorCommand implements Command {
	// 그림 그리기 대상
	protected Drawable drawable;
	// 그림 그리기 색
	private Color color;
	
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;
	}
	public void execute() {
		drawable.setColor(color);
	}
}