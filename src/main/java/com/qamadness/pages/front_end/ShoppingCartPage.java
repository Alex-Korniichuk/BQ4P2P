package com.qamadness.pages.front_end;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
public class ShoppingCartPage extends PageObject {

    @FindBy (xpath="//div[@class='highlighted-component shopping-cart-container']")
    WebElementFacade productsTable;

    @FindBy(xpath = "//a[@title='Clear Cart']")
    WebElementFacade clearCartBtn;


    public ShoppingCartPage(){
    }

    public Boolean checkIsProductInTheCart (){
        if (productsTable.isPresent() == true){
            System.out.println("Product is in the cart");
            return true;
        }else{
            assert (false);
            System.out.println("Cart is empty");
            return false;
        }
    }

    public void clearCart(){
        clearCartBtn.click();
        waitForRenderedElementsToBePresent(By.xpath("html/body/div[@id='emptyCart']/div/div"));
        WebElement containerFrame = getDriver().findElement(By.xpath("html/body/div[@id='emptyCart']/div/div"));
        //getDriver().switchTo().activeElement();
        waitForRenderedElementsToBePresent(By.xpath("html/body/div[@id='emptyCart']/div/div/form/div[3]/button[@type='submit']"));
        WebElement confirmBtn = getDriver().findElement(By.xpath("html/body/div[@id='emptyCart']/div/div/form/div[3]/button[@type='submit']"));
        confirmBtn.click();
        waitForRenderedElementsToBePresent(By.className("empty-cart-content"));

    }
}