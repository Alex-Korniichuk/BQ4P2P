package com.qamadness.pages.front_end;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 19.10.15.
 */
public class PendingRequestDetailsPage extends PageObject {

    @FindBy (css = ".btn.btn-danger")
    WebElementFacade withdrawRequestBtn;

    @FindBy (css = ".btn.btn-primary.dialog-yes-btn")
    WebElementFacade withdrawConfirmBtn;

    public PendingRequestDetailsPage (){}

    public void clickWithdrawRequestBtn (){
        withdrawRequestBtn.click();
    }

    public void clickConfirmWithdrawBtn (){
        withdrawConfirmBtn.click();
    }
}
