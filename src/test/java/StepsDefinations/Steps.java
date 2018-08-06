package StepsDefinations;

import org.testng.Assert;

import ActionClasses.Act;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.HashAttributeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.*;



public class Steps 
{
	Excel e;
	static Map<String ,String> m=new HashMap<String,String>();
	Act action;
	public static WebDriver driver;
	String urlname="https://webmail.qainfotech.com";
	public static int count=0;
	String str="";
	public void data()
	{
		for (Map.Entry<String, String> entry : m.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
	
	@Given("website url")
	public void website_url() 
	{  
		driver=new ChromeDriver();
		driver.get(urlname);
	}

	@When("we enter the credentials")
	public void we_enter_the_credentials() 
	{		
		driver.findElement(By.id("username")).sendKeys("anmolaggarwal");
		driver.findElement(By.id("password")).sendKeys("Anmol@81");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    
	}

	
	@Then("we get logged in")
	public void we_get_logged_in()
	{
		count++;
	  Assert.assertNotEquals(driver.getCurrentUrl(),"https://webmail.qainfotech.com");
	    
	}
	
	@When("we click on logout button")
	public void we_click_on_logout_button() 
	{
	  driver.findElement(By.className("DwtLinkButtonDropDownArrowTd")).click();	
	  driver.findElement(By.id("logOff_title")).click(); 
	}

	@Then("we get successfull logout")
	public void we_get_successfull_logout() 
	{
		count++;
	    Assert.assertEquals(driver.getCurrentUrl(),"https://webmail.qainfotech.com/?loginOp=logout");
	}
	
	@After
	public void ScenarioStatus(Scenario scenario) throws IOException
	{
	    str=scenario.getStatus()+" ";
	    String name = scenario.getName();
		System.out.println("the status names  is "+ name);
		System.out.println("the status string is "+str);
		m.put(name,str);		
		new Excel();
	}
	
}
