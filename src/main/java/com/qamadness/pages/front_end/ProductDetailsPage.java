package com.qamadness.pages.front_end;

/**
 * Created by alexandrakorniichuk on 08.10.15.
 */
import static org.junit.Assert.assertTrue;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProductDetailsPage extends PageObject {

    public static final String SUCCESSFULLY_ADDED = " was successfully added to Order Template.";

    @FindBy (xpath = "//ul[@class='nav nav-pills']/li[1]/a")
    WebElementFacade orderTemplatesDropDown;

    @FindBy (xpath = "//ul[@class='nav nav-pills']/li[1]/ul/li[3]/a")
    WebElementFacade orderTemplateItem;

    @FindBy (xpath = "//div[@id='sb-site']/div[4]/div[1]/div/h1")
    WebElementFacade productName;

    @FindBy (xpath = "//div[@class='rating-container']/a[@data-toggle='modal']")
    WebElementFacade writeReviewLink;

    @FindBy (xpath = "/html/body/div[5]/div/div/form[@id='review-form']/div[1]/div[2]/div[1]/div/span/fieldset/label[1]/em")
    WebElementFacade priceStars;

    @FindBy (xpath = "/html/body/div[5]/div/div/form[@id='review-form']/div[1]/div[2]/div[2]/div/span/fieldset/label[2]/em")
    WebElementFacade valueStars;

    @FindBy (xpath = "/html/body/div[5]/div/div/form[@id='review-form']/div[1]/div[2]/div[3]/div/span/fieldset/label[3]/em")
    WebElementFacade qualityStars;

    @FindBy (xpath = "/html/body/div[5]/div/div/form[@id='review-form']/div[1]/div[3]/input[@id='summary_field']")
    WebElementFacade reviewSummaryField;

    @FindBy (xpath = "/html/body/div[5]/div/div/form[@id='review-form']/div[1]/div[4]/textarea[@id='review_field']")
    WebElementFacade reviewTextArea;

    @FindBy (xpath = "/html/body/div[5]/div/div/form[@id='review-form']/div[2]/button[2]")
    WebElementFacade submitReviewBtn;

    @FindBy(css = ".tag-link>a")
    WebElementFacade addTagBtn;

    @FindBy(xpath = ".//*[@id='productTagName']")
    WebElementFacade tagNameField;

    @FindBy(css = "#bq-ui-2")
    WebElementFacade addTagConfirmBtn;

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

    public void clickWriteReviewLink (){
        writeReviewLink.click();
    }

    public void selectPriceRating (){
        priceStars.click();
    }

    public void selectValueRating (){
        valueStars.click();
    }

    public void selectQualityRating (){
        qualityStars.click();
    }

    public void enterReviewSummary (String reviewSummary){
        reviewSummaryField.type(reviewSummary);
    }

    public void enterReview (String review){
        reviewTextArea.type(review);
    }

    public void clickSubmitReviewBtn (){
        submitReviewBtn.click();
    }

    public void clickAddTagBtn() {addTagBtn.click();}

    public void enterTagName() {
        waitForRenderedElementsToBePresent(By.cssSelector("#productTagName"));
        WebElement nameField = getDriver().findElement(By.cssSelector("#productTagName"));
        nameField.sendKeys("autotest");
    }

    public void clickAddTagConfirmBtn() {addTagConfirmBtn.click();}

    //public void enterTagName() {tagNameField.sendKeys("autotest");}

}
