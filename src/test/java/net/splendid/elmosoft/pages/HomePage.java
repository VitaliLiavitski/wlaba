package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;

public class HomePage extends Page {
	
	@FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    private BrowserElement rightGamburgerMenu;
	
	
	public Boolean isHomePageOpened() {
		return rightGamburgerMenu.isExists();
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitForPageIsLoaded() {
		// TODO Auto-generated method stub
		
	}

}
