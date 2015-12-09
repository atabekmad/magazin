package org.mag.tests.signup;

import org.junit.Test;
import org.mag.tests.BaseTest;
import org.mag.pages.SignupPageModel;
import static org.mag.pages.PageUtils.*;
import static org.junit.Assert.fail;


public class SignupWithInvalidPasswordTest extends BaseTest
{
    private SignupPageModel signupPage;

    @Test // we expect an error in this Test
    public void Test()
    {
	// to do here
	String invalidPassword = getStringFromRegex("( ){1}");

	signupPage = new SignupPageModel();
	typeInto(signupPage.emailField, "atabekm21@gmail.com");  
	typeInto(signupPage.passwordField, invalidPassword);
	typeInto(signupPage.confirmPasswordField, invalidPassword);
	clickOn(signupPage.signupButton);

	// If the form was submitted without errors then fail the test
	if (signupPage.isFormSubmitted()) {
	    fail("Account was successfully signed up with invalid password");
	}
    }
}
