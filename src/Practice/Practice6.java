package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice6 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.manage().window().maximize();
	//To Print Row no. and Column no.	
		String input="Loblab Dan";
		WebElement table=driver.findElement(By.xpath("//table"));
		List<WebElement> tablerow=table.findElements(By.xpath(".//tbody//tr"));
		for(int i=0;i<tablerow.size();i++) {
			List<WebElement> tableData=tablerow.get(i).findElements(By.xpath(".//td"));
			for(int j=0;j<tableData.size();j++) {
				String data=tableData.get(j).getText();
				if(data.equals(input)) {
					//String IndexRow=tablerow.get(i).findElement(By.xpath(".//td[1]")).getText();
					System.out.println("Row:"+(i+1)+"  "+"Column:"+(j+1));
				}
			}
		}
		
		
	}
}