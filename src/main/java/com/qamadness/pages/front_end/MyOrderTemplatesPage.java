package com.qamadness.pages.front_end;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;

/**
 * Created by alexandrakorniichuk on 07.10.15.
 */
public class MyOrderTemplatesPage extends PageObject {

    @FindBy (xpath = "//button[@class='btn btn-default dropdown-toggle']")
    WebElementFacade expandOrderTemplateBtn;

    @FindBy (xpath = "//input[@class='form-control input-sm']")
    WebElementFacade newOrderTemplateInput;

    @FindBy (xpath = "//button[@class='btn btn-sm js-btn-submit']")
    WebElementFacade addNewOrderTemplateBtn;

    @FindBy (xpath = "//ul[@class='dropdown-menu template-menu']/li[3]/a")
    WebElementFacade orderTemplateItem;

    public MyOrderTemplatesPage(){}

    public void expandOrderTemplate (){
        expandOrderTemplateBtn.click();
    }

    public void createNewOrderTemplateName (){
        newOrderTemplateInput.type("Test template");
        addNewOrderTemplateBtn.click();
    }

    public void openOrderTemplatePage (){
        expandOrderTemplateBtn.click();
        waitForRenderedElementsToBePresent(By.xpath("//ul[@class='dropdown-menu template-menu']/li[3]/a"));
        orderTemplateItem.click();
    }

    public void deleteOrderTemplate (){
        waitForRenderedElementsToBePresent(By.xpath("//a[@class='btn btn-default']"));
        getDriver().findElement(By.xpath("//a[@class='btn btn-default']")).click(); //Click Delete button
        waitForRenderedElementsToBePresent(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]"));
        getDriver().findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click(); //Click 'Yes' button on the dialog window
        expandOrderTemplateBtn.click();
        //shouldNotBeVisible(orderTemplateItem);
        if (isElementVisible(By.xpath("//ul[@class='dropdown-menu template-menu']/li[3]/a")) == true){
            shouldNotBeVisible(orderTemplateItem);
        }
    }
}
