package org.mag.tests.search;


import java.util.Random;
import java.util.Arrays;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.support.ui.Select;
import org.mag.tests.BaseTest;
import org.mag.pages.SearchPageModel;
import static org.junit.Assert.fail;
import static org.mag.pages.PageUtils.*;


public class AddingProductsToCartsTest extends BaseTest 
{
    private SearchPageModel searchPage;

    @Test
    public void Test() 
    {
	searchPage = new SearchPageModel("atabekm21@gmail.com","password");
	searchPage.makeOrders(new String[]{"Test1","Test2","Test3"});
	searchPage.makeOrders(new String[]{"Test12","Test16"});

	if (!searchPage.areMyOrderedProductsDisplayedInCart()) {
	    fail("Ordered products and products shown in 'Cart items' aren't equal");
	}

	clickOn(searchPage.logOutButton);
	if (!searchPage.isLoginPageShown()) {
	    fail("Log In page wasn't shown after Log Out");
	}
    }
}
