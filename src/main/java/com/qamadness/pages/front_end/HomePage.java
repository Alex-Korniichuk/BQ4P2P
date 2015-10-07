package com.qamadness.pages.front_end;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {

    @FindBy(xpath="//*[@class='log-out-link']")
    WebElementFacade logoutLink;

    @FindBy (xpath = "//button[@class='lines-button sb-toggle-left']")
    WebElementFacade mainMenuBtn;

    @FindBy (xpath = "//ul[@id='nav-collapse-top-0']/li[7]/a")
    WebElementFacade shopBySupplierLink;

    @FindBy (xpath = "//li[@class='no-sub highlight']/a")
    WebElementFacade quickOrderLink;

    @FindBy (xpath = "//li[@class='my-account-nav']/a")
    WebElementFacade myAccountLink;

    @FindBy (xpath = "//ul[@id='nav-my-account']/li[5]/a")
    WebElementFacade orderTemplatesLink;

    public HomePage() {
    }

    public void checkIsUserLoggedIn (){
        if ((logoutLink.isPresent())==true) {
            System.out.println("User is logged in");
        }
        else {
            System.out.print("User isn't logged in");
            System.exit(0);
        }
    }

    public void clickMainMenuBtn(){
        mainMenuBtn.waitUntilClickable().click();
    }

    public void clickShopBySupplierLink (){
        shopBySupplierLink.click();
    }

    public void  clickQuickOrderLink (){
        quickOrderLink.click();
    }

    public void clickOrderTemplatesLink(){
        myAccountLink.click();
        orderTemplatesLink.click();
    }

}
