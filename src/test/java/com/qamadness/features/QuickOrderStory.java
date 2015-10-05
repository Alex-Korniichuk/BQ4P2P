package com.qamadness.features;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
import com.qamadness.steps.QuickOrderSteps;
import com.qamadness.steps.LoginSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Managed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class QuickOrderStory {


    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public QuickOrderSteps quickOrderSteps;

    @Issue("#AUT-38")
    @Test
    public void add_products_to_cart_by_uploading_CSV_file (){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        loginSteps.check_Is_User_Logged_In();
        loginSteps.click_Main_Menu_Btn();
        quickOrderSteps.click_Quick_Order_Link();
        quickOrderSteps.upload_File();
        quickOrderSteps.check_Is_Product_In_The_Cart();

    }
}
