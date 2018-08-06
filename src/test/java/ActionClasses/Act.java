package ActionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Act 
{
WebDriver driver;

public void initialisedriver(WebDriver driver,String url)
{
	this.driver=driver;
	this.driver.get(url);
}

public void enterdetails()
{
driver.findElement(By.id("username")).sendKeys("anmolaggarwal");
driver.findElement(By.id("password")).sendKeys("Anmol@1");
}
}
