package com.qamadness.pages.front_end;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vlad on 14.10.2015.
 */
public class MyTagsPage extends PageObject {

    @FindBy (linkText = "autotest")
    WebElementFacade ourTag;

    public void checkOurTag(){
        if (ourTag.isPresent() == true){
            System.out.println("Tag was added");
        }else{
            Assert.fail("Tag isn't added");
        }
    }

    public void clickTag() {ourTag.click();}

}
