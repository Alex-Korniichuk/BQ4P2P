package com.qamadness.pages.back_end;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 28.10.15.
 */
public class DashboardPage extends PageObject {

    @FindBy(xpath = "//a[@class='link-logout']")
    WebElementFacade logOutLink;

    @FindBy (css = ".menu-tab-text")
    WebElementFacade showMenuBtn;

    @FindBy (xpath = ".//*[@id='nav']/li[14]/a")
    WebElementFacade rFQSMenuBlock;

    @FindBy (xpath = ".//*[@id='dropdown_bq_28']/li[1]/a")
    WebElementFacade manageRFQFormsLink;

    public DashboardPage (){}

    public void checkThatAdminLoggedIn (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(logOutLink));
        if ((logOutLink.isPresent())==true) {
            System.out.println("Admin is logged in");
        }
        else {
            Assert.fail("Admin isn't logged in");
        }
    }

    public void clickShowMenuBtn(){
        showMenuBtn.click();
    }

    public void logOutFromAdmin (){
        logOutLink.click();
    }

    public void expandRFQSMenuBlock (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(rFQSMenuBlock));
        String tabState = rFQSMenuBlock.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed") == true){
            rFQSMenuBlock.click();
        }
    }

    public void clickManageRFQFormsLink (){ manageRFQFormsLink.click(); }
}
