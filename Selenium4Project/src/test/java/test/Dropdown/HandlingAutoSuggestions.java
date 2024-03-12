package test.Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAutoSuggestions {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://bing.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("sb_form_q")).sendKeys("autosuggestion");
		
		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//ul[@id='sa_ul']//li//span"));
		
		System.out.println("Number of autosuggestions: " + autoSuggestions.size()); //get number of options
		
		for(WebElement suggestion :autoSuggestions) {
			
			if(suggestion.getText().equals("autosuggestion meaning")) {
				suggestion.click();
				break;
			}
		}
		
		driver.close();
		
	}

}
