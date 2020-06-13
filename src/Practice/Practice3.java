package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.manage().window().maximize();

//Search for the given Text in Webtable and Print all the records of the Same Row
		String input="Jane Doe";
		WebElement table=driver.findElement(By.id("task-table"));
		List<WebElement> tablerow=table.findElements(By.xpath(".//tbody//tr"));
			for(int i=0;i<tablerow.size();i++) {
				List<WebElement> tabledata=tablerow.get(i).findElements(By.xpath(".//td"));
					for(int j=0;j<tabledata.size();j++) {
						String data=tabledata.get(j).getText();
						if(data.equals(input)) {
							String Output=tablerow.get(i).getText();
							System.out.println(Output);
							System.out.println("Row:"+(i+1));
							System.out.println("Column:"+(j+1));
						}
					}
			}
	}
}
