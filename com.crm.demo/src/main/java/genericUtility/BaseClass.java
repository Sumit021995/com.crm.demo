package genericUtility;

public class BaseClass {
	@BeforeSuit
	public void connectToDatabase()
	{
		System.out.println("Database Connected");
	}
	@BeforeClass
}
