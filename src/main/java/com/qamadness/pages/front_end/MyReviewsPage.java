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
 * Created by alexandrakorniichuk on 13.10.15.
 */
public class MyReviewsPage extends PageObject {

    @FindBy (xpath = "//div[@class='my-account']/div[2]/div[1]/div[1]/a[2]")
    WebElementFacade productName;

    @FindBy (xpath = "//div[@class='my-account']/div[2]/div[1]/div[2]/div/a")
    WebElementFacade reviewSummary;

    @FindBy (xpath = "//div[@class='my-account']/div[2]/div[1]/div[2]/div[2]/p")
    WebElementFacade review;

    public MyReviewsPage(){};

    public void checkProductName (String expectedProductName){
        String actualProductName = productName.getText();
        if (actualProductName.equalsIgnoreCase(expectedProductName)){
           System.out.println( "Review to correct product is displayed on the My Reviews page.");
        } else {
            Assert.fail("Review to: "+actualProductName+" is displayed on the My Review page, instead of: "+expectedProductName);
        }
    }

    public void checkReviewSummary (String expectedSummary){
        String actualSummary = reviewSummary.getText();
        if (actualSummary.equalsIgnoreCase(expectedSummary)){
            System.out.println ("Correct review summary is displayed on the My Reviews page");
        } else {
            Assert.fail(actualSummary+" - review summary is displayed instead of "+expectedSummary);
        }
    }

    public void checkReview (String expectedReview){
        String actualReview = review.getText();
        if (actualReview.equalsIgnoreCase(expectedReview)){
        } else {
            Assert.fail(actualReview+" - review summary is displayed instead of "+expectedReview);
        }
    }
}
