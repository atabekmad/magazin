package org.mag.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.mag.pages.PageUtils.*;


public class SignupPageModel
{
    private String url = "http://testmeagain.github.io/AngularBootstrapExample/#/signup";

    @FindBy(id="inputEmail")
    public WebElement emailField;

    @FindBy(id="inputPassword1")
    public WebElement passwordField;

    @FindBy(id="inputPassword2")
    public WebElement confirmPasswordField;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement signupButton;

    public SignupPageModel()
    {
	driver.get(url);
	WebElement linkToSignupPage = (new WebDriverWait(driver, 10))
	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '#/signup')]")));
	linkToSignupPage.click(); // get us to Signup Page
	PageFactory.initElements(driver,this);
    }

    public boolean isFormSubmitted()
    {
	return (driver.getCurrentUrl().endsWith("/#/login"));
    }
}
