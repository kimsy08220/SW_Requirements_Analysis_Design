package practice1;

public class PrinterProxy implements Printable {
	private String name;
	private Printable real;
	private String className;
	
	public PrinterProxy() {}
	public PrinterProxy(String name, String className) {
		this.name = name;
		this.className = className;
	}
	public synchronized void setPrinterName(String name) {
		if (real != null)
			real.setPrinterName(name);
		this.name = name;
	}
	public String getPrinterName() {
		return name;
	}
	public void print(String string) {		// proxy�� ó���� �� ����
		realize();
		real.print(string);
	}
	private synchronized void realize() {
		if (real == null) {
			try {
				real = (Printable)Class.forName(className).newInstance();
				real.setPrinterName(name);
			} catch (ClassNotFoundException e) {
				System.err.println("Ŭ���� " + className + " �� �߰ߵ��� �ʽ��ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
			
	}
}