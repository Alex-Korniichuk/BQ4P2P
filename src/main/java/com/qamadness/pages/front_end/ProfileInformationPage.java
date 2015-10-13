package com.qamadness.pages.front_end;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(id = "current_password")
    WebElementFacade currentPassField;

    @FindBy(id = "password")
    WebElementFacade newPassField;

    @FindBy(id = "confirmation")
    WebElementFacade confirmNewPassField;

    @FindBy (xpath = "//div[@class='my-account']/form[2]/fieldset/div[2]/div[4]/button[2]")
    WebElementFacade savePassBtn;

    @FindBy (xpath = "//select[@id='default_language']")
    WebElementFacade languageDropDown;

    @FindBy (xpath = "//select[@id='default_currency']")
    WebElementFacade currencyDropDown;

    @FindBy (xpath = "//form[@id='form-validate']/fieldset/div[2]/div[3]/button[2]")
    WebElementFacade savePreferencesBtn;

    @FindBy (xpath = "//form[@id='form-validate']/fieldset/div[1]/legend/span")
    WebElementFacade preferencesSectionHeader;


    public ProfileInformationPage (){}

    public void enterFirstName (String name){
        firstNameField.type(name);
    }

    public void enterLastName (String lastName){
        lastNameField.type(lastName);
    }

    public void clickSaveProfileBtn (){
        saveProfileBtn.click();
    }

    public void checkUserName (String expectedFirstName, String expectedLastName){
        String actualFirstName = displayedFirstName.getText();
        System.out.println("User first name that is displayed on the site: " + actualFirstName);
        int lettersQty = actualFirstName.length();
        String actualLastName = displayedFullName.getText().replaceAll("\n", "").substring(lettersQty);
        System.out.println("Last Name is: "+actualLastName);
        if (actualFirstName.equalsIgnoreCase(expectedFirstName) && actualLastName.equalsIgnoreCase(expectedLastName)){
            System.out.println("First name and last name were changed correctly");
        } else{
            Assert.fail("Expected name is: "+expectedFirstName+" Actual name is: "+actualFirstName+" Expected last name is: "+expectedLastName+" Actual last name is: "+actualLastName+". Error: name was changed to incorrect one.");
        }
    }

    public void enterCurrentPass (String currentPass){
        currentPassField.type(currentPass);
    }

    public void enterNewPass (String newPass){
        newPassField.type(newPass);
    }

    public void enterConfirmPass (String confPass){
        confirmNewPassField.type(confPass);
    }

    public void clickSavePassBtn (){
        savePassBtn.click();
    }

    public void selectLanguage (String languageValue){
        languageDropDown.selectByValue(languageValue);
    }

    public void selectCurrency (String currencyValue){
        currencyDropDown.selectByValue(currencyValue);
    }

    public void clickSavePreferencesBtn (){
        savePreferencesBtn.click();
    }

    public void checkFRLanguage (){
        String actualSectionHeader = preferencesSectionHeader.getText();
        String expectedSectionHeaderFR = "Mon Profil";
        if (actualSectionHeader.equalsIgnoreCase(expectedSectionHeaderFR)){
            System.out.println ("Language is changed to FR");
        } else {
            Assert.fail("Language isn't changed correctly. Section header is: "+actualSectionHeader+". Expected FR section header is: "+expectedSectionHeaderFR);
        }
    }

    public void check_Currency (String actualCurrency, String expectedCurrency){
        if (actualCurrency.equalsIgnoreCase(expectedCurrency)){
            System.out.println("Currency is changed correctly");
        } else {
            Assert.fail("Actual currency is: "+actualCurrency+". Expected currency is: "+expectedCurrency);
        }
    }

}
