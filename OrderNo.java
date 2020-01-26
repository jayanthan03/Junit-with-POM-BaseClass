package org.JUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderNo extends BaseClass {
	public OrderNo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='order_no']")
	private WebElement orderNo;

	public WebElement getOrderNo() {
		return orderNo;
	}

}
