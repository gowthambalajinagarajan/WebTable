package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Practice1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.manage().window().maximize();
		
//Verify the text is present in WebTable
		
		String input="Holden Charles";
		boolean flag=false;
		WebElement table=driver.findElement(By.xpath("//table"));
		List<WebElement> tablerow=table.findElements(By.xpath(".//tbody//tr"));
		for(WebElement row:tablerow) {
			List<WebElement> tabledata=row.findElements(By.xpath(".//td"));
			for(WebElement data:tabledata) {
				//System.out.println(data.getText());
				if(data.getText().equals(input)) {
					System.out.println("Available");
					flag=true;
				}
			}
		}
		if(flag==false) {
			System.out.println("Not Available");
		}
	}

}
