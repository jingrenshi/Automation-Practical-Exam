package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Page;
import util.BrowserFactory;

public class AddCategoryTest {

	WebDriver driver;
	
	String category = "Jingren";
	String dupCategory = "hahaha";
	Page page;
	
	@BeforeTest
	public void beforeTest() {
		driver = BrowserFactory.init();
	    page = PageFactory.initElements(driver, Page.class);
	}
	
	
	@Test
	public void validateAddCategory() {
		
		
		
		page.insertCategory(category);
		page.cliclAddCategoryButton();
		boolean displayResult = page.validateCategoryIsDisplayed();
		Assert.assertTrue(displayResult);
	}
	
	@Test
	public void validateDuplicatedCategory() {
		boolean result = page.addDuplicatedCategory(dupCategory);
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateMonthDropDown() {
		driver.get("https://techfios.com/test/101/index.php");
		boolean result = page.validateMonth();
		Assert.assertTrue(result);
	}
}
