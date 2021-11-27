import factory.*;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}
		// ����� ���ڷκ��� �ش� ������ ����
		Factory factory = Factory.getFactory(args[0]);
		
		// ��ũ ����
		Link joins = factory.createLink("�߾��Ϻ�", "http://www.joins.com");
		Link hani = factory.createLink("�Ѱ跹 �Ź�", "http://www.hani.co.kr/");
		
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link kr_yahoo = factory.createLink("Yahoo!korea", "http://www.yahoo.com/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com/");
		
		// Ʈ���̸� ������ ��, ��ũ�� �� Ʈ���̿� �߰�
		Tray traynews = factory.createTray("�Ź�");
		traynews.add(joins);
		traynews.add(hani);
		
		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(kr_yahoo);
		
		Tray traysearch = factory.createTray("�˻�����");
		traysearch.add(trayyahoo);		// Ʈ���� "Yahoo!"�� "�˻�����" Ʈ���̿� �߰�
		traysearch.add(excite);
		traysearch.add(google);
		
		// �������� ������ ��, Ʈ���̸� �� �������� �߰�
		Page page = factory.createPage("LinkPage", "ȫ�浿");
		page.add(traynews);
		page.add(traysearch);
		
		// HTML ������ ����
		page.output();
	}
}
