package com.qamadness.pages.front_end;

/**
 * Created by alexandrakorniichuk on 08.10.15.
 */
import static org.junit.Assert.assertTrue;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class ProductDetailsPage extends PageObject {

    public static final String SUCCESSFULLY_ADDED = " was successfully added to Order Template.";

    @FindBy (xpath = "//ul[@class='nav nav-pills']/li[1]/a")
    WebElementFacade orderTemplatesDropDown;

    @FindBy (xpath = "//ul[@class='nav nav-pills']/li[1]/ul/li[3]/a")
    WebElementFacade orderTemplateItem;

    @FindBy (xpath = "//div[@id='sb-site']/div[4]/div[1]/div/h1")
    WebElementFacade productName;


    public ProductDetailsPage () {}

    public void openOrderTemplateDropDown (){
        orderTemplatesDropDown.click();
    }

    public void addProductToTemplate (){
        orderTemplateItem.click();
    }

    public String getProductName (){
        return productName.getText();
    }



}
