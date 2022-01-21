package net.splendid.elmosoft.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import net.elmosoft.splendid.browser.DriverManager;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.HomePage;
import net.splendid.elmosoft.pages.LoginPage;

public class SocialNetworkTest extends BaseSplendidTest {
	
	@Test
	public void verifyTwitter() {
		LoginPage login = new LoginPage();
		login.openPage().checkPage();
		login.doLogin("standard_user", "secret_sauce");
		
		HomePage home = new HomePage();
		home.clickByTwitterBtn();
		String expectedTwitterUrl = "https://twitter.com/saucelabs";
		Assert.assertEquals(home.getNewTabCurrentUrl(1), expectedTwitterUrl, "Twitter is not opened!");
		
	}
	
	@Test
	public void verifyFacebook() {
		LoginPage login = new LoginPage();
		login.openPage().checkPage();
		login.doLogin("standard_user", "secret_sauce");
		
		HomePage home = new HomePage();
		home.clickByFacebookBtn();
		String expectedTwitterUrl = "https://www.facebook.com/saucelabs";
		Assert.assertEquals(home.getNewTabCurrentUrl(1), expectedTwitterUrl, "Facebook is not opened!");
		
	}
	
	@AfterMethod(alwaysRun = true, description = "Method Level Tear Down")
	public void clodeTab(final ITestContext testContext) {
		DriverManager.closeAllOpenedBrowsers();
	}

}
