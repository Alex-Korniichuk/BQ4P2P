package com.qamadness.pages.back_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 28.10.15.
 */
public class RequestForQuotePage extends PageObject {

    @FindBy (xpath = ".//div[@class='form-group webforms-fields-title']/div[1]/input")
    WebElementFacade titleField;

    @FindBy (xpath = ".//div[@class='form-group webforms-fields-deadline']/div/div/span")
    WebElementFacade quoteDeadlineCalendarBtn;

    @FindBy (xpath = ".//div[@class='form-group webforms-fields-due_date']/div/div/span")
    WebElementFacade needByDateCalendarBtn;

    @FindBy (xpath = ".//div[@class='form-group webforms-fields-description']/div/textarea")
    WebElementFacade descriptionTextArea;

    @FindBy (xpath = ".//div[@class='form-group webforms-fields-comments']/div/textarea")
    WebElementFacade commentsTextArea;

    @FindBy (xpath = "//input[@type='file']")
    WebElementFacade uploadFileInput;

    @FindBy (xpath = ".//*[@class='btn btn-primary']")
    WebElementFacade submitFormBtn;

    @FindBy (id = "search_buyerquest_erfq_request_grid")
    WebElementFacade searchField;

    @FindBy (xpath = ".//div[@class='pull-right']/button")
    WebElementFacade cancelButton;

    @FindBy (xpath = ".//div[@id='confirm_dialog']/div/div/div[3]/a")
    WebElementFacade confirmQuoteCancelBtn;

    @FindBy (xpath = ".//*[@id='sb-site']/div[4]/div[1]/div/h1")
    WebElementFacade requestForQuoteID;

    public RequestForQuotePage (){}

    public void enterQuoteTitle (String title){
        titleField.type(title);
    }

    public void selectQuoteDeadline (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(quoteDeadlineCalendarBtn));
        quoteDeadlineCalendarBtn.click();
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();
        int currentDate = Integer.parseInt(dateFormat.format(cal.getTime()));
        if (currentDate <= 20){
            int deadlineDate = currentDate+3;
            String deadlineDateStr = Integer.toString(deadlineDate);
            System.out.println(deadlineDateStr);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='day' and contains(text(), '" + deadlineDateStr + "')]")));
            getDriver().findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='day' and contains(text(), '" + deadlineDateStr + "')]")).click();
        } else {
            getDriver().findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='new day' and contains(text(), '1')]")).click();
        }

    }

    public void selectQuoteNeedByDate (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(needByDateCalendarBtn));
        needByDateCalendarBtn.click();
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();
        int currentDate = Integer.parseInt(dateFormat.format(cal.getTime()));
        if (currentDate <= 20){
            int neededByDate = currentDate+5;
            String neededByDateStr = Integer.toString(neededByDate);
            System.out.println(neededByDateStr);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='day' and contains(text(), '" + neededByDateStr + "')]")));
            getDriver().findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='day' and contains(text(), '" + neededByDateStr + "')]")).click();
        } else {
            getDriver().findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='new day' and contains(text(), '3')]")).click();
        }
    }

    public void enterQuoteDescription (String desc){
        descriptionTextArea.type(desc);
    }

    public void enterQuoteComment (String comment){
        commentsTextArea.type(comment);
    }

    public void uploadFile () {
        setImplicitTimeout(120, TimeUnit.SECONDS);
        ((JavascriptExecutor) getDriver()).executeScript("document.getElementsByName('upload_files').item(0).style.opacity = '100';");
        //uploadFileInput.sendKeys("/Users/alexandrakorniichuk/IdeaProjects/BQ4P2P/src/test/resources/QuickOrderProducts.csv"); - use this method if upload method doesn't work
        upload("QuickOrderProducts.csv").to(uploadFileInput);
        resetImplicitTimeout();
    }

    public void clickSubmitFormButton (){
        submitFormBtn.click();
    }

    public void searchForQuoteRequest (String title){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.type(title);
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-block")));
    }

    public String getRequestForQuoteID (){
        return requestForQuoteID.getText();
    }

    public void cancelQuoteRequest (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
        wait.until(ExpectedConditions.visibilityOf(confirmQuoteCancelBtn));
        confirmQuoteCancelBtn.click();
    }



}
