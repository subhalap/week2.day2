package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main"); //Launch browser
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");//Login
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click(); //Click on CRM/SFA link
		
		driver.findElement(By.linkText("Leads")).click(); //Click on leads link
		
		driver.findElement(By.linkText("Find Leads")).click(); //Click on find leads link

		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys("Subhalaxmi"); //Enter first name
		driver.findElement(By.linkText("Find Leads")).click();//Click Find leads button
		
		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click(); //Click on first resulting lead
		String title = "View Lead";
		String title2 = driver.getTitle();
		if (title.equalsIgnoreCase(title2)) {
			System.out.println("Title matched");
		}else 
			System.out.println("Title not matched");
		//System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click(); //Click Edit
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear(); //Change the company name
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.sendKeys("Zoho");
		
		driver.findElement(By.name("submitButton")).click(); //Click Update
		
		boolean title3 = driver.findElement(By.id("updateLeadForm_companyName")).isDisplayed(); //Confirm the changed name appears
		System.out.println(title3);
		
		driver.close(); // Close the browser
	
	}

}
