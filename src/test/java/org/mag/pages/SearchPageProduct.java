package org.mag.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static org.mag.pages.PageUtils.*;


public class SearchPageProduct
{
    String name;
    String color;
    Date date;
    Boolean inStock;
    float price;
    WebElement orderButton;

    public SearchPageProduct(WebElement element)
    {
	List<WebElement> divrows = element.findElements(By.cssSelector("div.col-md-4.ng-binding"));
	Map<String, String> data = new HashMap<String, String>();
	
	for (WebElement row : divrows) {
	    String s = row.getText();     // e.g. "Name: Test1"
	    String[] sp = s.split(": ");  // e.g. {"Name", "Test1"}
	    if (sp.length > 1) {
		data.put(sp[0],sp[1]);
	    }
	}

	this.name = data.get("Name");
	this.color = data.get("Color");
	this.date = convertStringToDate(data.get("Date"));
	this.inStock = Boolean.valueOf(data.get("InStock"));
	this.price = Float.parseFloat(data.get("Price").replace("$","").replace(",",""));
	this.orderButton = element.findElement(By.tagName("button"));
    }

    public Date convertStringToDate(String s)
    {
	try {
	    DateFormat format = new SimpleDateFormat("MM/dd/yyyy"); 
	    Date date = format.parse(s);
	 
	} catch (ParseException e) {
	    e.toString();
	} finally {
	    return date;
	}
    }
}
