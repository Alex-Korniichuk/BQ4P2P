package com.qamadness.features;

import com.qamadness.steps.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vlad on 14.10.2015.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class MyTagsStory {

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
    public MyTagsSteps myTagsSteps;

    @Steps
    public ProductDetailsPageSteps productDetailsPageSteps;

    @Issue("AUT-43")
    @Pending @Test
    public void Tag_can_be_added_from_product_details_page() {
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.open_Product_Details_Page();
        productDetailsPageSteps.click_Add_Tag_Button();
        //myTagsSteps.addTagName();
        productDetailsPageSteps.enter_Tag_Name();
        productDetailsPageSteps.click_Add_Tag_Confirm_Button();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_My_Tags_Page();
        myTagsSteps.check_Tag_On_My_Tags_Page();
        myTagsSteps.click_appropriate_Tag();
    }
}
