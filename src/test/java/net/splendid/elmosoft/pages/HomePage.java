package net.splendid.elmosoft.pages;

import java.util.ArrayList;
import java.util.List;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class HomePage extends Page {

	@FindBy(xpath = "//button[contains(text(), 'Open Menu')]")
	private BrowserElement rightGamburgerMenu;

	@FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
	private List<BrowserElement> addToCartBtns;

	@FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']")
	private BrowserElement cartIcon;

	@FindBy(xpath = "//a[contains(text(), 'Twitter')]")
	private BrowserElement twitterBtn;

	@FindBy(xpath = "//a[contains(text(), 'Facebook')]")
	private BrowserElement faceBookBtn;

	@FindBy(xpath = "//h2[@class='complete-header']")
	private BrowserElement infMessage;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<BrowserElement> nameProductsList;

	@FindBy(xpath = "//*[@value='za']")
	private BrowserElement sortingZtoA;

	@FindBy(xpath = "//*[@value='az']")
	private BrowserElement sortingAtoZ;
	
	@FindBy(xpath = "//select[@class='product_sort_container']/option")
    private BrowserElement sortBtn;
	
	
	public void selectSort(String nameSort) {
		sortBtn.selectOptionByValue(nameSort);
	}
	

	public ArrayList<String> getListOfProductNames() {
		ArrayList<String> names = new ArrayList<String>();

		for (BrowserElement element : nameProductsList) {
			String name = element.getText();
			names.add(name);
		}
		return names;
	}

	public String getSuccessMessage() {
		return infMessage.getText();
	}

	public TwitterPage clickByTwitterBtn() {
		twitterBtn.click();
		return PageFactory.initElements(driver, TwitterPage.class);
	}

	public FaceBookPage clickByFacebookBtn() {
		faceBookBtn.click();
		return PageFactory.initElements(driver, FaceBookPage.class);
	}

	public String getNewTabCurrentUrl(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index));
		return driver.getCurrentUrl();
	}

	public HomePage clickByAddToCartBtn(int index) {
		addToCartBtns.get(index).click();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public YourCartPage clickByCartIcon() {
		cartIcon.click();
		return PageFactory.initElements(driver, YourCartPage.class);
	}

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
