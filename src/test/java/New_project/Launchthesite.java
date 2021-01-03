package New_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Launchthesite {
	public WebDriver d;

	  @Test (priority=1)
	  public void a() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\selenium jars\\chrome\\chromedriver.exe");
	d= new ChromeDriver ();
	d.manage().window().maximize();
	d.get("http://www.amazon.com");
	d.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("books");
	d.findElement(By.xpath("//*[@id='nav-search-submit-text']/input")).click();
	}
	  
	  
	  }


