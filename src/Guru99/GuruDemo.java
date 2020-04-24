package Guru99;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuruDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement table=driver.findElement(By.xpath("//table[@class='dataTable']"));
		List<WebElement> tablerow=table.findElements(By.xpath(".//tbody//tr"));
		for(WebElement row:tablerow) {
			List<WebElement> tabledata=row.findElements(By.xpath(".//td"));
			String CurrentPrice=row.findElement(By.xpath(".//td[4]")).getText();
				//System.out.println(CurrentPrice);
				Double Price=Double.parseDouble(CurrentPrice);
				if(Price<500) {
					String Company=row.findElement(By.xpath(".//td[1]")).getText();
					System.out.println(Company);
				}
			}
	}
}

