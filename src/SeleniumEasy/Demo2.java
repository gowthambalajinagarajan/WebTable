package SeleniumEasy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.manage().window().maximize();
		
		String input="failed qa";
		
		String Xpath="//table//tbody//tr//td[text()='"+input+"']";
		List<WebElement> tablerow=driver.findElements(By.xpath(Xpath));
		System.out.println("Number of Given Input Present is:"+tablerow.size());
	}
}
