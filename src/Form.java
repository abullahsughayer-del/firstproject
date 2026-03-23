import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Form {
	
	WebDriver driver = new EdgeDriver();
	String MyWebSite = "https://www.saucedemo.com/";
	@BeforeTest
	public void Mysetup() {
		
	driver.get(MyWebSite);
	driver.manage().window().maximize();
	
	}
		
@Test
	public void MyTest() {
	





}



@AfterTest 
public void AfterMyTest() {
	
	
	
	
	
	
	
}










}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
