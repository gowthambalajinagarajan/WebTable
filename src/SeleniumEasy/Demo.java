package SeleniumEasy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.manage().window().maximize();
		
		String input="SEO tags";
		WebElement table=driver.findElement(By.xpath("//table"));
		List<WebElement> tablerow=table.findElements(By.xpath(".//tbody//tr"));
		for(WebElement row:tablerow) {
			String data=row.findElement(By.xpath(".//td[2]")).getText();
			if(data.equals(input)) {
				String Output=row.findElement(By.xpath(".//td[4]")).getText();
				System.out.println(Output);
			}
		}
	}
}