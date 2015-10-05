package com.qamadness.features;

import com.qamadness.steps.CompareProductsSteps;
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
public class CompareProductsStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public CompareProductsSteps compareProductsSteps;

    @Issue("#AUT-36")
    @Test
    public void product_can_be_added_to_cart_from_Compare_Products_page() {
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        loginSteps.check_Is_User_Logged_In();
        loginSteps.click_Main_Menu_Btn();
        compareProductsSteps.click_Shop_By_Supplier_Link();
        compareProductsSteps.open_Supplier_Page_With_Products();
        compareProductsSteps.add_Products_To_Comparison();
        compareProductsSteps.go_To_Comparison_Page();
        compareProductsSteps.add_Product_To_Cart();
        compareProductsSteps.remove_All_Products_From_Comparison();
        compareProductsSteps.open_Shopping_Cart();
        compareProductsSteps.check_Is_Product_In_The_Cart();
    }

    @Pending @Test
    public void products_can_be_removed_from_comparison() {
    }
}
