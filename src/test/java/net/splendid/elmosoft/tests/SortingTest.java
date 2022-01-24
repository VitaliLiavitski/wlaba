package net.splendid.elmosoft.tests;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.HomePage;
import net.splendid.elmosoft.pages.LoginPage;

@Listeners({ SuiteListener.class, HTMLReporter.class })
@Epic("Smoke Tests")
@Feature("Sorting")
@Guice
public class SortingTest extends BaseSplendidTest {
	
	
	@Test
	public void verifySorting() {
		LoginPage login = new LoginPage();
		login.openPage().checkPage();
		login.doLogin("standard_user", "secret_sauce");
		
		HomePage home = new HomePage();
		home.selectSort("za");
		
		ArrayList<String> expectedOrders = new ArrayList<String>();
		expectedOrders = home.getListOfProductNames();
		Collections.sort(expectedOrders);
		
		home.selectSort("az");
		ArrayList<String> actualdOrders = new ArrayList<String>();
		actualdOrders = home.getListOfProductNames();
		
		Assert.assertEquals(actualdOrders, expectedOrders, "Sorting work is not correct!");
		
		
	}

}
