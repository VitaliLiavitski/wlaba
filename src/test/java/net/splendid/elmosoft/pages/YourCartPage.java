package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class YourCartPage extends Page{

	
	@FindBy(xpath = "//div[contains(text(), 'Sauce Labs Backpack')]")
    private BrowserElement product;
	
	@FindBy(id = "remove-sauce-labs-backpack")
    private BrowserElement removeBtn;
	
	@FindBy(xpath = "//div[@class='cart_item_label']")
    private BrowserElement cartItemLabel;
	
	
	public YourCartPage clickByRemove() {
		removeBtn.click();
		return PageFactory.initElements(driver, YourCartPage.class);
	}
	
	public Boolean isProductChoosen() {
		return product.isExists();
	}
	
	public Boolean isCartItemLabelExist() {
		return cartItemLabel.isExists();
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
