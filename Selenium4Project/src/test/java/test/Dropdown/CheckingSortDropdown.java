package test.Dropdown;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckingSortDropdown {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//a[@href=\"/newsearchserviceneed\"]")).click();
		
		WebElement drpCategory = driver.findElement(By.xpath("//select[@name='category_id']"));
		Select category = new Select(drpCategory);
		
		ArrayList originalList = new ArrayList(); //serves as a container
		ArrayList tempList = new ArrayList(); 
		
		
		List<WebElement> categoryOptions = category.getOptions();
		
		for (WebElement option : categoryOptions) {
			
			originalList.add(option.getText()); //getting the text value of each option and adding it onto the arraylist^^
			tempList.add(option.getText());
		}
		
		System.out.println("Original list: " + originalList);
		System.out.println("Temp list: " + tempList);
		
		Collections.sort(tempList); //sort the option values stored in tempList
		
		System.out.println("Original list no sorting" + originalList);
		System.out.println("Temp list after sorting" + tempList); //print sorted option values stored in tempList
		
		
		//verify if the dropdown list is sorted by comparing the actual list vs sorted list
		if(originalList.equals(tempList)) {
			
			System.out.println("Dropdown is sorted");
		}
		else {
			System.out.println("Dropdown is unsorted");
		}
		
		driver.close();
		
		
	}

}
