import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MyTestCases {
WebDriver driver = new ChromeDriver();
	
	Connection con ;
	Statement stmt ;
	
	ResultSet rs ;
	
	
String firstName ;
String lastName ;



@BeforeTest
public void mysetup() throws SQLException  {
	
	driver.get("https://smartbuy-me.com/account/register");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","abc123");
	
	
	
}

@Test(priority = 1) 
public void UpdateTheDate() throws SQLException, InterruptedException {
	
	String Query = "update customers set customerName = ' abu soso' where customerNumber = 103";
	stmt =  con.createStatement();
	
	int rowupdated = stmt.executeUpdate(Query);
	System.out.println(rowupdated);
	Thread.sleep(2000);
}



@Test(priority = 2)
public void ReadTheDateInsideTheBrowser() throws SQLException {

	
	
	String Query = "select * from customers where customerNumber= 103";
     stmt = con.createStatement();
	rs =  stmt.executeQuery(Query);
	
		System.out.println(rs);
	
	while(rs.next()) {
		firstName = rs.getString("customerName");
		lastName = rs.getString("contactLastName");
	}
	
	
	
	
	WebElement FirstName =  driver.findElement(By.id("customer[first_name]"));
	
	FirstName.sendKeys(firstName);
	
	
	WebElement LastName = driver.findElement(By.id("customer[last_name]"));
	
	LastName.sendKeys(lastName);
	
	
}





@AfterTest
public void  AfterMytest() {}




}