package com.qamadness.pages.front_end;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;


/**
 * Created by alexandrakorniichuk on 13.10.15.
 */
public class CollaborativeCartsPage extends PageObject {

    @FindBy (xpath = "//form[@id='add-group-form']/fieldset/div[2]/div[1]/input")
    WebElementFacade groupNameField;

    @FindBy (xpath = "//form[@id='add-group-form']/fieldset/div[2]/div[3]/button[2]")
    WebElementFacade saveGroupBtn;

    @FindBy (xpath = "//div[@id='collaborative-cart-groups']/div[2]/div/div/address/strong")
    WebElementFacade groupNameTitle;

    @FindBy (xpath = "//div[@id='collaborative-cart-groups']/div[2]/div/div/address/ul/li[2]/a")
    WebElementFacade leaveGroupLink;

    @FindBy (xpath = "html/body/div[@id='confirm_dialog_1']/div/div/div[3]/button[2]")
    WebElementFacade leaveGroupConfirmationBtn;

    public CollaborativeCartsPage (){}

    public void enterNewGroupName (){
        groupNameField.type("Test New Group");
    }

    public void clickSaveGroupBtn (){
        saveGroupBtn.click();
    }

    public void checkThatGroupIsCreated (){
        String groupTitle = groupNameTitle.getText();
        if (groupTitle.equalsIgnoreCase("Test New Group")){
            System.out.println ("New group with correct name is created");
        } else {
            Assert.fail("New group is created with incorrect name: "+groupTitle);
        }
    }

    public void clickLeaveGroupLink (){
        leaveGroupLink.click();
    }

    public void clickConfirmBtn (){
        leaveGroupConfirmationBtn.click();
    }
}
