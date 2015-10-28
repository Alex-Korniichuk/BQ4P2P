package com.qamadness.features;

import com.qamadness.steps.front_end_steps.*;
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
    public HomePageSteps homePageSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public CompareProductsPageSteps compareProductsPageSteps;

    @Steps
    public ShoppingCartPageSteps shoppingCartPageSteps;


    @Issue("#AUT-36")
    @Test
    public void product_can_be_added_to_cart_from_Compare_Products_page() {
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.add_Products_To_Comparison();
        shopBySupplierPageSteps.go_To_Comparison_Page();
        compareProductsPageSteps.add_Product_To_Cart();
        compareProductsPageSteps.remove_All_Products_From_Comparison();
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
    }

    @Pending @Test
    public void products_can_be_removed_from_comparison() {
    }
}
