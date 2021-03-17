package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case, launch the browser and login
	//@Test -- execute test cases
	//after each test case, close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page does not match");
	}
	
	@Test(priority=2)
	public void validateUserNameLabel() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}
	
	@Test(priority=3)
	public void validateContactsLink() {
		testUtil.switchToFrame();
		contactsPage =  homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void validateDealsLink() {
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void validateTasksLink() {
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
