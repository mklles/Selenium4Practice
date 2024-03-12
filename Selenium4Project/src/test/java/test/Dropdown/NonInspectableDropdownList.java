package test.Dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NonInspectableDropdownList {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//a[@href=\"/newsearchserviceneed\"]")).click();
		
		WebElement locationDrp = driver.findElement(By.id("autocomplete"));
		locationDrp.clear();
		locationDrp.sendKeys("Korea");
		
		String text;
		
		do {
			
			locationDrp.sendKeys(Keys.ARROW_DOWN); //going thru the list by performing arrow down
			text = locationDrp.getAttribute("value"); // auto selecting value, getting the value attribute
			
			if(text.contains("Korea Utara")) {
				locationDrp.sendKeys(Keys.ENTER);
				break;
				
			}			
		}
		while(!text.isEmpty());
		
		
		
	}

}
