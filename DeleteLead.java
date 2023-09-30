package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException  {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main"); //Launch browser
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");//Login
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click(); //Click on CRM/SFA link
		
		driver.findElement(By.linkText("Leads")).click(); //Click on leads link
		
		driver.findElement(By.linkText("Find Leads")).click(); //Click on find leads link
		driver.findElement(By.xpath("//span [text() = 'Phone']")).click(); //Click on Phone
		driver.findElement(By.name("phoneNumber")).sendKeys("99"); //Enter phone number
		driver.findElement(By.className("x-btn-text")).click(); //Click on find lead
		
		Thread.sleep(2000);
		
		String FirstLead = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']//a")).getText();
		System.out.println(FirstLead); //Capture lead ID of First Resulting lead
		
		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']//a")).click(); //Click First Resulting lead
		driver.findElement(By.className("subMenuButtonDangerous")).click();  //Click Delete
		
		driver.findElement(By.className("x-btn-text")).click(); //Click on find lead
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class = 'x-form-element']//input[@name = 'id']")).sendKeys(FirstLead); //Enter captured lead ID
		driver.findElement(By.className("x-btn-text")).click(); //Click on find lead
		
		String message = driver.findElement(By.xpath("(//div[@class = 'x-panel-bc'])[8]")).getText();
		System.out.println(message); //Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		
		if(message.contains("No records to display")) {
			System.out.println("Lead ID is deleted");
		}else
			System.out.println("Lead ID is not deleted");
		
		driver.close();

	}

}
