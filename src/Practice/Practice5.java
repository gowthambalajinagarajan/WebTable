package Practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice5 {
	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\Users\\acer\\Desktop\\Java\\Demo.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheet("Sheet1");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		for(int i=0;i<sh.getPhysicalNumberOfRows();i++) {
			Row r=sh.getRow(i);
			Cell c=r.getCell(0);
			String text=c.getStringCellValue();
			WebElement add=driver.findElement(By.id("twotabsearchtextbox"));
			add.clear();
			add.sendKeys(text);
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			String Result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
			System.out.println(Result);
		}
	}
}