package com.qamadness.pages.front_end;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy (xpath = "//ul[@id='nav-level-one']/li[2]/a")
    WebElementFacade productsAnServicesTab;

    @FindBy (css = ".dropdown.mini-cart-link>a")
    WebElementFacade miniShoppingCartLink;

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
        waitForRenderedElements(By.xpath("//ul[@id='nav-collapse-top-0']/li[7]/a"));
        shopBySupplierLink.click();
    }

    public void  clickQuickOrderLink (){
        quickOrderLink.click();
    }

    public void clickOrderTemplatesLink(){
        myAccountLink.click();
        orderTemplatesLink.click();
    }

    public void expandProductsAndServicesTab (){
        String tabState = productsAnServicesTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed") == true){
            productsAnServicesTab.click();
        }

    }

    public void openShoppingCart (){
        miniShoppingCartLink.click();
        WebDriverWait wait = new WebDriverWait(getDriver(),40);
        WebElement openShoppingCartBtn = wait.until(ExpectedConditions.elementToBeClickable(net.serenitybdd.core.annotations.findby.By.xpath("//a[@class='btn btn-primary btn-sm']")));
        openShoppingCartBtn.click();
    }

}
