package com.qamadness.features;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
import com.qamadness.steps.HomePageSteps;
import com.qamadness.steps.QuickOrderPageSteps;
import com.qamadness.steps.LoginSteps;
import com.qamadness.steps.ShoppingCartPageSteps;
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
    public HomePageSteps homePageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public QuickOrderPageSteps quickOrderPageSteps;

    @Steps
    public ShoppingCartPageSteps shoppingCartPageSteps;

    @Issue("#AUT-38")
    @Pending@Test
    public void add_products_to_cart_by_uploading_CSV_file (){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.click_Quick_Order_Link();
        quickOrderPageSteps.upload_File();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();

    }
}
