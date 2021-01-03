package New_project;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrangeHrn {
	public static WebDriver d;
	
	@Test (priority=1)
	  public void a() throws InterruptedException  {
	System.setProperty("webdriver.chrome.driver","D:\\selenium jars\\chrome 86\\chromedriver.exe");
	d= new ChromeDriver ();
	d.manage().window().maximize();
	d.get("http://www.orangehrm.com/");
	Thread.sleep(5000);
	System.out.println(d.getTitle());
    d.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/a")).click();
	((JavascriptExecutor)d).executeScript("window.scrollTo(0,4000)");
	Thread.sleep(5000);
	String copyright= d.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[5]/div/p")).getText();
	System.out.println("This text present in the bottom of the page "+copyright);
	Thread.sleep(5000);
	((JavascriptExecutor)d).executeScript("window.scrollTo(0,-100)");
	Thread.sleep(5000);
	d.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div[6]/a[2]")).click();
	System.out.println(d.getTitle());
	d.findElement(By.xpath("/html/body/nav/div/div[1]/a/img")).click();
	Thread.sleep(5000);
	((JavascriptExecutor)d).executeScript("window.scrollTo(0,3500)");
	Thread.sleep(5000);
	d.findElement(By.xpath("/html/body/div[11]/div/div/a")).click();
	System.out.println(d.getTitle());
	d.findElement(By.xpath("//*[@id=\"Form_submitForm_FirstName\"]")).sendKeys("sameer");
	d.findElement(By.xpath("//*[@id=\"Form_submitForm_LastName\"]")).sendKeys("nalawade");
	d.findElement(By.xpath("//*[@id=\"Form_submitForm_CompanyName\"]")).sendKeys("quality");
	WebElement ddn=d.findElement(By.xpath("//*[@id=\"Form_submitForm_NoOfEmployees\"]"));
	
	Select employees=new Select (ddn);
	employees.selectByIndex(7);
	d.findElement(By.xpath("//*[@id=\"Form_submitForm_JobTitle\"]")).sendKeys("star india");
	d.findElement(By.xpath("//*[@id=\"Form_submitForm_Contact\"]")).sendKeys("9819532988");
	d.findElement(By.xpath("//*[@id=\"Form_submitForm_Email\"]")).sendKeys("sam@gmail.com");
WebElement ddn1=d.findElement(By.xpath("//*[@id=\"Form_submitForm_Country\"]"));
	
	Select country=new Select (ddn1);
	country.selectByValue("Bhutan");
	
	
	
	
	
	

}
	
}
