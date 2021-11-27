import factory.*;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}
		// 명령행 인자로부터 해당 공장을 생성
		Factory factory = Factory.getFactory(args[0]);
		
		// 링크 생성
		Link joins = factory.createLink("중앙일보", "http://www.joins.com");
		Link hani = factory.createLink("한계레 신문", "http://www.hani.co.kr/");
		
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link kr_yahoo = factory.createLink("Yahoo!korea", "http://www.yahoo.com/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com/");
		
		// 트레이를 생성한 후, 링크를 이 트레이에 추가
		Tray traynews = factory.createTray("신문");
		traynews.add(joins);
		traynews.add(hani);
		
		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(kr_yahoo);
		
		Tray traysearch = factory.createTray("검색엔진");
		traysearch.add(trayyahoo);		// 트레이 "Yahoo!"를 "검색엔진" 트레이에 추가
		traysearch.add(excite);
		traysearch.add(google);
		
		// 페이지를 생성한 후, 트레이를 이 페이지에 추가
		Page page = factory.createPage("LinkPage", "홍길동");
		page.add(traynews);
		page.add(traysearch);
		
		// HTML 문서를 만듦
		page.output();
	}
}
