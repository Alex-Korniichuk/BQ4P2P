package com.qamadness.pages.front_end;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */


import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("https://dev.buyerquest.net/p2pdev2/customer/account/login/")
public class LoginPage extends PageObject {
    @FindBy(id = "email")
    WebElementFacade emailField;

    @FindBy(id="pass")
    private net.serenitybdd.core.pages.WebElementFacade passField;

    @FindBy(id="send2")
    private net.serenitybdd.core.pages.WebElementFacade loginBtn;

    public LoginPage() {
    }

    public void enterEmail (String email){
        emailField.type(email);
    }

    public void enterPassword (String password){
        passField.type(password);
    }

    public void clickLoginBtn (){
        loginBtn.click();
    }
}
