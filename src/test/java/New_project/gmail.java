package New_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmail {
	public static WebDriver d;
	public static WebElement mail;
	public static Properties prop;

	public static void main(String[] args) throws IOException {
		File f=new File("D:\\Samsel\\Maven\\src\\test\\java\\New_project\\config.properties");
		FileInputStream loginData=new FileInputStream(f);
		
		prop=new Properties ();
		prop.load(loginData);
		
		String sitename=prop.getProperty("url");
		String crmph=prop.getProperty("chromedriverpath");
		
		System.setProperty("webdriver.chrome.driver", crmph);
		d=new ChromeDriver ();
		d.get(sitename);
		String eml=prop.getProperty("email");
		mail=d.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		mail.sendKeys(eml);
		
		

	}

}

