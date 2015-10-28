package com.qamadness.pages.back_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by alexandrakorniichuk on 28.10.15.
 */
public class ManageRFQFormsPage extends PageObject {

    @FindBy (id = "erfqGrid_filter_name")
    WebElementFacade requestFormNameField;

    @FindBy (xpath = ".//*[@id='erfqGrid_table']/tbody/tr/td[4]/a")
    WebElementFacade previewLink;

    public ManageRFQFormsPage (){}

    public void searchForRequestFormByName (String name){
        requestFormNameField.type(name);
        requestFormNameField.sendKeys(Keys.ENTER);
    }

    public void clickPreviewLink (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        String winHandleBefore = getDriver().getWindowHandle();
        previewLink.click();
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }
}
