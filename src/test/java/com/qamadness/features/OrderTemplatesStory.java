package com.qamadness.features;

import com.qamadness.steps.LoginSteps;
import com.qamadness.steps.OrderTemplateSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by alexandrakorniichuk on 07.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class OrderTemplatesStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public OrderTemplateSteps orderTemplateSteps;

    @Issue("AUT-39")
    @Test
    public void create_new_template(){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        loginSteps.check_Is_User_Logged_In();
        loginSteps.click_Main_Menu_Btn();
        orderTemplateSteps.open_My_Order_Templates_Page();
        orderTemplateSteps.create_New_Order_Template();
        orderTemplateSteps.delete_Order_Template();
    }

}
