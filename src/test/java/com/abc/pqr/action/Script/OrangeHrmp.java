package com.abc.pqr.action.Script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmp {
	
	public static WebDriver d;
	public static XSSFWorkbook Wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium jars\\chrome 86\\chromedriver.exe");
		d= new ChromeDriver ();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		d.get("http://www.orangehrm.com/");
		System.out.println(d.getTitle());
		File f=new File ("D:\\Samsel\\Maven\\src\\test\\java\\com\\abc\\pqr\\data\\New file.xlsx");
	    FileInputStream fis=new FileInputStream (f);
	    d.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/span/a")).click();
	    Wb =new XSSFWorkbook (fis);
		sheet = Wb.getSheet ("sheet1");
		String name =sheet.getRow(0).getCell(0).getStringCellValue();
		String surname=sheet.getRow(1).getCell(1).getStringCellValue();
		d.findElement(By.xpath("//*[@id=\"Form_submitForm_FirstName\"]")).sendKeys(name);
		d.findElement(By.xpath("//*[@id=\"Form_submitForm_LastName\"]")).sendKeys(surname);
		
	}

}
