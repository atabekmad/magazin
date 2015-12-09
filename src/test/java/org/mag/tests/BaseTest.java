package org.mag.tests;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;
import static org.mag.pages.PageUtils.*;


public class BaseTest
{
    @Before
    public void setup()
    {
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("browser.startup.homepage", "about:blank");
	profile.setPreference("startup.homepage_welcome_url", "about:blank");
	profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
	driver = new FirefoxDriver(profile);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void close()
    {
	driver.close();
    }
}
