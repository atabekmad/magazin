package org.mag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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
	driver.findElement(By.xpath("//a[contains(@href, '#/signup')]")).click(); // get us to Signup Page
	PageFactory.initElements(driver,this);
    }

    public boolean isFormSubmitted()
    {
	return (driver.getCurrentUrl().endsWith("/#/login"));
    }
}
