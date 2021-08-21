package factory;

public abstract class practice2_Factory {
	public static practice2_Factory getFactory(String classname) {
		practice2_Factory factory = null;
		try {
			factory = (practice2_Factory)Class.forName(classname).newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스" + classname + " 발견되지 않았습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
	public abstract Link createLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);
	
	public Page createYahooPage() {
		Link link = createLink("Yahoo!", "http://www.yahoo.com/");
		Page page = createPage("Yahoo!", "Yahoo!");
		page.add(link);
		return page;
	}
}
