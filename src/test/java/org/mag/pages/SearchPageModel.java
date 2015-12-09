package org.mag.pages;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.mag.pages.SearchPageProduct;
import static org.mag.pages.PageUtils.*;


public class SearchPageModel 
{
    private String url = "http://testmeagain.github.io/AngularBootstrapExample/#/login";
    private Select colorOptions;
    private List<String> orderedProducts;
    private List<WebElement> productBlockContainers;
    private Map<String, SearchPageProduct> productsMap;

    @FindBy(linkText="Log out")
    public WebElement logOutButton;

    @FindBy(partialLinkText="Cart:")
    public WebElement viewCart;

    @FindBy(id="date-from")
    public WebElement dateFrom;

    @FindBy(id="date-to")
    public WebElement dateTo;

    @FindBy(xpath="//input[@type='checkbox']")
    public WebElement inStock;

    @FindBy(xpath="xpath=(//input[@type='text'])[3]")
    public WebElement minPrice;

    @FindBy(xpath="xpath=(//input[@type='text'])[4]")
    public WebElement maxPrice;

    @FindBy(name="colors")
    public WebElement colorDropDown;

    
    public SearchPageModel(String email, String password) 
    {
	registerAccount(email,password);
	loginWithAccount(email,password);
	PageFactory.initElements(driver,this);

	try {    
	    // Instead of sleep we could wait explicitly for particular element to appear but
	    // products on page may vary (html) and we don't know what exact element to wait for 
	    TimeUnit.MILLISECONDS.sleep(500);  
	} catch(InterruptedException e) {
	    e.toString();
	}

	this.colorOptions = new Select(colorDropDown);
	this.updateProductsMap();
	this.orderedProducts = new ArrayList<String>();
    }

    public void updateProductsMap()
    {
	this.productBlockContainers = driver.findElements(By.cssSelector("div.media-body.container"));
	productsMap= new HashMap<String, SearchPageProduct>();

	for (WebElement element : productBlockContainers) {
	    SearchPageProduct product = new SearchPageProduct(element);
	    productsMap.put(product.name, product);
	}
    }

    public void selectColor(String color)
    {

	colorOptions.selectByValue(color);
    }

    public boolean isLoginPageShown()
    {
	return (driver.getCurrentUrl().endsWith("/#/login"));
    }


    public boolean doDisplayedProductsHaveColorOf(String color)
    {
	int before=0;
	for (Map.Entry<String, SearchPageProduct> entry : productsMap.entrySet()) {
	    if (entry.getValue().color == color) {
		    before++;
		}
	}

	int after=0;
	this.updateProductsMap();
	for (Map.Entry<String, SearchPageProduct> entry : productsMap.entrySet()) {
	    if (entry.getValue().color == color) {
		    after++;
	    }	
	}

	return (after==before);
    }

    public void makeOrders(String[] productOrders)
    {
	for (String order : productOrders) {
 	    productsMap.get(order).orderButton.click();
	    orderedProducts.add(order);
	}
    }

    public boolean areMyOrderedProductsDisplayedInCart()
    {
	clickOn(viewCart);
	WebElement unorderedList = driver.findElement(By.cssSelector("div.modal-body.ng-scope"));
	List<WebElement> listItems = unorderedList.findElements(By.tagName("li"));
	List<String> itemsShown = new ArrayList<String>();

	for (WebElement listItem : listItems) {
	    itemsShown.add(listItem.getText());
	}
	
	driver.findElement(By.cssSelector("button.btn.btn-primary")).click();	    
	return (Arrays.equals(itemsShown.toArray(), orderedProducts.toArray()));
    }
}
