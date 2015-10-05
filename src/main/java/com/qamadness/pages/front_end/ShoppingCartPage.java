package com.qamadness.pages.front_end;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
public class ShoppingCartPage extends PageObject {

    @FindBy (xpath="//div[@class='highlighted-component shopping-cart-container']")
    WebElementFacade productsTable;

    @FindBy (xpath = "//span[@class='fa fa-times']")
    WebElementFacade deleteProductsBtn;

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

    public void removeProducts(){
        deleteProductsBtn.click();
    }
}
