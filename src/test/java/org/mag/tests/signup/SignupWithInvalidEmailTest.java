package org.mag.tests.signup;

import org.junit.Test;
import org.mag.tests.BaseTest;
import org.mag.pages.SignupPageModel;
import static org.mag.pages.PageUtils.*;
import static org.junit.Assert.fail;


public class SignupWithInvalidEmailTest extends BaseTest
{
    private SignupPageModel signupPage;

    @Test // we expect an error in this Test
    public void Test()
    {
	signupPage = new SignupPageModel();
	typeInto(signupPage.emailField, "@gmail.com");  
	typeInto(signupPage.passwordField, "password");
	typeInto(signupPage.confirmPasswordField, "password");
	clickOn(signupPage.signupButton);

	if (signupPage.isFormSubmitted()) {
	    fail("The form was submitted although emailField was invalid");
	}
    }
}
