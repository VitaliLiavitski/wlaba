package net.splendid.elmosoft.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.LoginPage;
import net.splendid.elmosoft.steps.GoogleSteps;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import com.google.inject.Inject;

@Listeners({ SuiteListener.class, HTMLReporter.class })
@Epic("Demo Tests")
@Feature("REX Tab")
@Guice
public class Authorization extends BaseSplendidTest {


	@Test(description = "Do authorization")
	public void verifyAuthorization() {
		LoginPage login = new LoginPage();
		login.openPage().checkPage();
		Boolean resultOfAuthorization = login.login("standard_user", "secret_sauce").isHomePageOpened();
		Assert.assertTrue(resultOfAuthorization, "User is not authorizated!");
	}
}
