package BrokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws Throwable   {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		  
		 List<WebElement> links = driver.findElements(By.tagName("a"));

		 for(WebElement element : links){
		 String url = element.getAttribute("href");
		 
		 URL link=new URL(url);

		 HttpURLConnection connection = (HttpURLConnection)link.openConnection();
		 connection.connect();
		 int statusCode = connection.getResponseCode();
		 if(statusCode>= 400){
		 System.out.println(url+" is a broken link");
		 }
		 else{
		 System.out.println(url+" is a valid link");
		 }
		 }

	}

}
