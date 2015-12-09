package org.mag.tests.login;

import org.junit.Ignore;
import org.junit.Test;
import org.mag.tests.BaseTest;
import org.mag.pages.LoginPageModel;
import org.mag.pages.SignupPageModel;
import static org.junit.Assert.fail;
import static org.mag.pages.PageUtils.*;


public class LoginWithRegisteredAccountTest extends BaseTest 
{
    private LoginPageModel loginPage;
    private SignupPageModel signupPage;

    @Test
    public void Test()
    {
	String email = "atabekm21@gmail.com";
	String password = "password";
	
	// Register an account first
	registerAccount(email, password);
	
	// And then Log In with it
	loginPage = new LoginPageModel();
	typeInto(loginPage.emailField, email);
	typeInto(loginPage.passwordField, password);
	clickOn(loginPage.loginButton);
	
	if (!loginPage.isSearchPageShown()) {
	    fail("Failed to Log In. User wasn't redirected to Search page");
	}
    }
}
