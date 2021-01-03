package New_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class policybazar {
	public static WebDriver d;
	public static Properties prop;
	public static WebElement mob;
	public static WebElement pro;
	
	
	public static void main(String[] args) throws IOException {
		File f=new File("D:\\Samsel\\Maven\\src\\test\\java\\New_project\\policybazar.properties");
		FileInputStream loginData=new FileInputStream(f);
		
		prop=new Properties ();
		prop.load(loginData);
		
		String sitename=prop.getProperty("url");
		String crmph=prop.getProperty("chromedriverpath");
		System.setProperty("webdriver.chrome.driver", crmph);
		d=new ChromeDriver ();
		d.get(sitename);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		System.out.println(d.getTitle());
		String mobi=prop.getProperty("mobile");
		
		mob=d.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		mob.sendKeys(mobi);
		d.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
		d.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
        String mobile1=prop.getProperty("mobno");
		
		pro=d.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		pro.sendKeys(mobile1);
	    d.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	    d.navigate().back();
	    d.navigate().back();
	    
	    TakesScreenshot scrShot =((TakesScreenshot)d);
	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    String mobile11="d:\\sameer\\mobile note 9 pro.jpg";
	    File DestFile=new File(mobile11);
	   FileUtils.copyFile(SrcFile, DestFile);
		
	}

}
