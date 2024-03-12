package test.Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdowns {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		

		
        driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement dropdownEle = driver.findElement(By.name("country_id"));
		
		Select drpOptions = new Select(dropdownEle);

		List<WebElement> listOfOptions = drpOptions.getOptions();
		
		for(WebElement option : listOfOptions) {
			if(option.getText().equals("China")) {
				option.click();
				break; //break loop after performing the desired action > clicking China
			}
		}
		
		//drpOptions.selectByIndex(2);
		//drpOptions.selectByValue("10"); //text from the value attribute
		//drpOptions.selectByVisibleText("Philippines");
		
		
		//=============================================== Handling multiple dropdowns=======================================
		
		driver.get("");
		
		WebElement numberOfEmployee = driver.findElement(By.name(""));
		SelectOptionFromDropdown(numberOfEmployee,"10-20");
		
		
		WebElement industry = driver.findElement(By.name(""));
		SelectOptionFromDropdown(industry, "Pharmacy");
		
		WebElement country = driver.findElement(By.name(""));
		SelectOptionFromDropdown(country, "Japan"); 


	}
	
	// select dropdown value method to use for multiple dropdown
	
	//parameter WebElement as the dropdown and String as the item to be selected
	
	public static void SelectOptionFromDropdown(WebElement ele, String value){
		
		Select drpOptions = new Select(ele);
		
		List<WebElement> allOptions = drpOptions.getOptions(); // geting all options in the dropdown
		
		for (WebElement op : allOptions) { // for each option in the option list
			
			if(op.getText().equals(value)) { // get its text and click if it is equal to the string value
				op.click();
				break;
			}
		}
		
		
		
		
	} 

	
	

} 
