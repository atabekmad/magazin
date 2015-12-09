package org.mag.tests.search;

import org.junit.Test;
import org.mag.tests.BaseTest;
import org.mag.pages.SearchPageModel;
import static org.junit.Assert.fail;
import static org.mag.pages.PageUtils.*;


public class LogOutTest extends BaseTest 
{
    private SearchPageModel searchPage;

    @Test
    public void Test()
    {
	searchPage = new SearchPageModel("atabekm21@gmail.com","password");
	clickOn(searchPage.logOutButton);
	
	if (!searchPage.isLoginPageShown()) {
	    fail("Log In page wasn't shown after Log Out");
	}
    }
}
