package com.qamadness.steps;

/**
 * Created by alexandrakorniichuk on 30.09.15.
 */

import com.qamadness.pages.front_end.LoginPage;
import com.qamadness.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    LoginPage frontEndLoginPage;

    @Step
    public void open_Page() {
        frontEndLoginPage.open();
    }

    @Step
    public void enter_Credentials(String email, String password){
        frontEndLoginPage.enterEmail(email);
        frontEndLoginPage.enterPassword(password);
    }

    @Step
    public void click_Login_Btn(){
        frontEndLoginPage.clickLoginBtn();
    }


}
