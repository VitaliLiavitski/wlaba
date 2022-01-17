package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class LoginPage extends Page {
	
	@FindBy(id="user-name")
    private BrowserElement loginField;
	
	@FindBy(id="password")
    private BrowserElement passwordField;
	
	@FindBy(id="login-button")
    private BrowserElement loginBtn;
	
	
	public HomePage doLogin(String username, String password) {
		loginField.type(username);
		passwordField.type(password);
		loginBtn.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public LoginPage openPage() {
        driver.get("https://www.saucedemo.com");
        return PageFactory.initElements(driver, LoginPage.class);
    }
	

	@Override
	public void checkPage() {
		 waitForPageIsLoaded();
		 loginBtn.waitForElementDisplayed(TEN_SECONDS_WAIT);
		
	}

	@Override
	public void waitForPageIsLoaded() {
		 driver.waitForPageLoad();
	}
}
