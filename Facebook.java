package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/"); //Launch browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Add implicit wait
		
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click(); //Click on Create New Account button
		driver.findElement(By.name("firstname")).sendKeys("Subha"); //Enter the first name
		driver.findElement(By.name("lastname")).sendKeys("Panigrahi"); //Enter the last name
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890"); //Enter the mobile number
		driver.findElement(By.id("password_step_input")).sendKeys("Subha01"); //Enterthe password
		
		WebElement day = driver.findElement(By.xpath("//select[@id = 'day']"));
		Select daydd = new Select(day);
		daydd.selectByVisibleText("6");
		
		Thread.sleep(2000);
		
		WebElement month = driver.findElement(By.xpath("//select[@id = 'month']"));
		Select monthdd = new Select(month);
		monthdd.selectByIndex(3);
		
		Thread.sleep(2000);
		
		WebElement year = driver.findElement(By.xpath("//select[@id = 'year']"));
		Select yeardd = new Select(year);
		yeardd.selectByVisibleText("1995");
		
		driver.findElement(By.xpath("//input[@value = '1']")).click();
		
		driver.findElement(By.name("websubmit")).click();

		
		
	}

}
