package com.qamadness.pages.front_end;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

/**
 * Created by alexandrakorniichuk on 09.10.15.
 */
public class ProfileInformationPage extends PageObject {

    @FindBy (id = "firstname")
    WebElementFacade firstNameField;

    @FindBy (id = "lastname")
    WebElementFacade lastNameField;

    @FindBy (id = "email")
    WebElementFacade emailField;

    @FindBy (xpath = "//div[@id='main-content']/div[2]/div[2]/div/form[1]/fieldset/div[2]/div[5]/button[2]")
    WebElementFacade saveProfileBtn;

    @FindBy (xpath = "//div[@class='title h4']/span")
    WebElementFacade displayedFirstName;

    @FindBy(xpath = "//div[@class='title h4']")
    WebElementFacade displayedFullName;

    public ProfileInformationPage (){}

    public void enterFirstName (){
        firstNameField.type("NewFirstName");
    }

    public void enterLastName (){
        lastNameField.type("NewLastName");
    }

    public void clickSaveProfileBtn (){
        saveProfileBtn.click();
    }

    public void checkUserName (){
        String actualUserFirstName = displayedFirstName.getText();
        System.out.println("User first name that is displayed on the site: " + actualUserFirstName);
        int lettersQty = actualUserFirstName.length();
        String actualLastName = displayedFullName.getText().substring(lettersQty);
        System.out.println("Last Name is: "+actualLastName);
    }

}
