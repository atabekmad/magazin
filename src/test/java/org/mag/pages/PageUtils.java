package org.mag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.mag.pages.SignupPageModel;
import org.mag.pages.LoginPageModel;
import com.mifmif.common.regex.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;


public final class PageUtils
{
    private static LoginPageModel loginPage;
    private static SignupPageModel signupPage;
    public static WebDriver driver;

    public static void typeInto(WebElement element, String s)
    {
	element.clear();
	element.sendKeys(s);
    }

    public static void clickOn(WebElement element)
    {
	element.click();
    }

    public static void registerAccount(String email, String password)
    {
	signupPage = new SignupPageModel();
	typeInto(signupPage.emailField, email);
	typeInto(signupPage.passwordField, password);
	typeInto(signupPage.confirmPasswordField, password);
	clickOn(signupPage.signupButton);
	
	if (!signupPage.isFormSubmitted()) {
	    fail("Form wasn't submitted successfully. User wasn't redirected to Log In page");
	}
    }
    
    public static void loginWithAccount(String email, String password)
    {
	loginPage = new LoginPageModel();
	typeInto(loginPage.emailField, email);
	typeInto(loginPage.passwordField, password);
	clickOn(loginPage.loginButton);
	
	if (!loginPage.isSearchPageShown()) {
	    fail("Failed to Log In. User wasn't redirected to Search loginPage");
	}
    }	

    public static String getStringFromRegex(String Regex)
    {
	return (new Generex(Regex)).random();
    }
}


    
