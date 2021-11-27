import factory.*;

public class practice2_Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}
		practice2_Factory factory = practice2_Factory.getFactory(args[0]);
		Page page = factory.createYahooPage();
		page.output();
	}
}
