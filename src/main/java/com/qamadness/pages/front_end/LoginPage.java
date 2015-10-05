package com.qamadness.pages.front_end;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://dev.buyerquest.net/p2pdev2/customer/account/login/")
public class LoginPage extends PageObject {
    @FindBy(id = "email")
    private net.serenitybdd.core.pages.WebElementFacade emailField;

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
