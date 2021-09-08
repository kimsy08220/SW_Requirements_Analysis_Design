package practice2;

public class TextBuilder extends Builder {
	private StringBuffer buffer = new StringBuffer();
	
	public void buildTitle(String title) {
		buffer.append("======================================================\n");
		buffer.append("¡º" + title + "¡»\n");
		buffer.append("\n");
	}
	public void buildString(String str) {
		buffer.append('¡á' + str + "\n");
		buffer.append("\n");
	}
	public void buildItems(String[] items) {
		for (int i = 0; i < items.length; i++)
			buffer.append("¡Ü" + items[i] + "\n");
		buffer.append("\n");
	}
	public String getResult() {
		return buffer.toString();
	}
	public void buildDone() {
		buffer.append("======================================================\n");
	}
}
