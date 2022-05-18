package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Page extends BasePage {
	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "#extra > input[type=text]:nth-child(7)")
	WebElement CATEGORY_INPUT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name= 'due_month']")
	WebElement MONTH_DROP_DOWN_ELEMENT;

	String generatedCategory;
	public void insertCategory(String category) {
		int generatedNumber = generateRandomNumber(999);
		generatedCategory = category + generatedNumber;
		CATEGORY_INPUT_ELEMENT.sendKeys(generatedCategory);

	}

	public void cliclAddCategoryButton() {
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}

	public boolean validateCategoryIsDisplayed() {

		String categoryText = driver.findElement(By.xpath("//span[contains(text(), '" + generatedCategory + "')]")).getText();
		System.out.println(categoryText);
		boolean displayResult = driver.findElement(By.xpath("//span[contains(text(), '" + generatedCategory + "')]")).isDisplayed();
		return displayResult;
	}
	
	public boolean addDuplicatedCategory(String dupCategory) {
		CATEGORY_INPUT_ELEMENT.sendKeys(dupCategory);
		ADD_CATEGORY_BUTTON_ELEMENT.click();
		String pageSource = driver.getPageSource();
		if(pageSource.contains(dupCategory)) {
			System.out.println("The category you want to add already exists: " + dupCategory);
		}
		return true;
	}
	
	public boolean validateMonth() {
		Select sel = new Select(MONTH_DROP_DOWN_ELEMENT);
		List <WebElement> allOptions = sel.getOptions();
		int size = allOptions.size();
		for(int i=0; i<size; i++) {
			String value = allOptions.get(i).getText();
			System.out.println(value);
		}
		if(size == 13) {
			return true;
		}else {
			return false;
		}
	}
}
