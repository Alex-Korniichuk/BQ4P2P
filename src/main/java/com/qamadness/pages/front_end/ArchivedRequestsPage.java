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
public class ArchivedRequestsPage extends PageObject {

    @FindBy (id = "search_purchase_request_history_grid")
    WebElementFacade searchRequestField;

    @FindBy (css = ".btn.btn-search")
    WebElementFacade searchBtn;

    @FindBy (css = ".grid-row.in>td>a")
    WebElementFacade requestIDLink;

    public ArchivedRequestsPage (){}

    public void searchRequestByID (String requestID){
        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_purchase_request_history_grid")));
        searchRequestField.type(requestID);
        searchBtn.click();
    }

    public void checkSearchResult (String expectedRequestID){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-block>span")));
        String actualRequestID = requestIDLink.getText();
        if (actualRequestID.equalsIgnoreCase(expectedRequestID)){
            System.out.println ("Correct search result. Order is found");
        } else {
            Assert.fail("Incorrect search result. Order wasn't found on Archived Requests page");
        }
    }
}
