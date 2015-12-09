package org.mag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.mag.pages.PageUtils.*;


public class LoginPageModel
{
    private String url = "http://testmeagain.github.io/AngularBootstrapExample/#/login";

    @FindBy(id="inputEmail")
    public WebElement emailField;

    @FindBy(id="inputPassword1")
    public WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;

    public LoginPageModel()
    {
	driver.get(url);
	PageFactory.initElements(driver,this);
    }

    public boolean isSearchPageShown()
    {
	return (driver.getCurrentUrl().endsWith("/#/search"));
    }
}




