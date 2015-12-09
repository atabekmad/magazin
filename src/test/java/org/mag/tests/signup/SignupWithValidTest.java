package org.mag.tests.signup;

import org.junit.Test;
import org.mag.tests.BaseTest;
import org.mag.pages.SignupPageModel;
import static org.junit.Assert.fail;
import static org.mag.pages.PageUtils.*;


public class SignupWithValidTest extends BaseTest
{
    private SignupPageModel signupPage;

    @Test
    public void Test()
    {
	signupPage = new SignupPageModel();
	typeInto(signupPage.emailField, "atabekm21@gmail.com");
	typeInto(signupPage.passwordField, "password");
	typeInto(signupPage.confirmPasswordField, "password");
	clickOn(signupPage.signupButton);
	
	if (!signupPage.isFormSubmitted()) {
	    fail("Form wasn't submitted successfully. User wasn't redirected to Log In page");
	}
    }
}
