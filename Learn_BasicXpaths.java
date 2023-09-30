package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learn_BasicXpaths {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
	
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class = 'inputLogin']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("crmsfa");

		
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		
	}

}
