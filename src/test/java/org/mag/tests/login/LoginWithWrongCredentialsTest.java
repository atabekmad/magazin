package org.mag.tests.login;

import org.junit.Ignore;
import org.junit.Test;
import org.mag.tests.BaseTest;
import org.mag.pages.LoginPageModel;
import static org.junit.Assert.fail;
import static org.mag.pages.PageUtils.*;


public class LoginWithWrongCredentialsTest extends BaseTest 
{
    private LoginPageModel loginPage;

    @Test
    public void Test()
    {
	// This isn't a reliable test. To improve there
	// has to be some set of invalid usernames(emails)
	// which will be used for this type of test

	loginPage = new LoginPageModel();
	typeInto(loginPage.emailField, "NotAllowedToCreate@email.com"); 
	typeInto(loginPage.passwordField, "   ");
	clickOn(loginPage.loginButton);
	
	if (loginPage.isSearchPageShown()) {
	    fail("User was able to login with wrong credentials.");
	}
    }
}
