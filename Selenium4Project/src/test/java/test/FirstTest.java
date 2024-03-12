package test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	public static void main(String args[]) {
		
		//system.setProperty("webdriver.chrome.driver", "");
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//driver.manage().window().maximize();
		/*
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		
	

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		WebElement drp = driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown']/div[text()='Select Friend']"));
		
		
		js.executeScript("window.scrollBy(0,500)");
		
		//scroll to element
		js.executeScript("arguments[0].scrollIntoView();", drp);
		
		driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown']/div[text()='Select Friend']")).click();
		
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
		
		for (WebElement element : dropdownOptions) {
			
			System.out.println(element.getText());
			
		}
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.get("https://www.w3schools.com/java/java_data_types_numbers.asp");*/
		
		//String firstHandle = driver.getWindowHandle();
		
		/*assert driver.getWindowHandles().size() == 0;
		
		driver.findElement(By.xpath("//a[@href=\"tryjava.asp?filename=demo_type_byte\"]")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		
		Set<String> handles = driver.getWindowHandles();
		
		for(String thisHandle : handles) {
			

			//System.out.println(handles.size());
			driver.switchTo().window(thisHandle);
			System.out.println(driver.getTitle());
			WebElement textArea = driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']"));
			textArea.click();
			textArea.sendKeys(Keys.chord(Keys.CONTROL + "a" + "test"));
		}*/
		

		
		//driver.switchTo().window(firstHandle);
		
		//driver.switchTo().frame("google_ads_iframe_/22152718,16833175/sws-hb//w3schools.com//bottom_medium_rectangle_0");
		
		//==========================break loop if already got the expected=======================
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement dropdownEle = driver.findElement(By.name("country_id"));
		
		Select drpOptions = new Select(dropdownEle);

		List<WebElement> listOfOptions = drpOptions.getOptions();
		
		for(WebElement option : listOfOptions) {
			if(option.getText().equals("China")) {
				option.click();
				break; //break loop after performing the desired action
			}
		}
		
		//drpOptions.selectByIndex(2);
		//drpOptions.selectByValue("10"); //text from the value attribute
		//drpOptions.selectByVisibleText("Philippines");
		
		//driver.close();
		//driver.quit();
	}

}
