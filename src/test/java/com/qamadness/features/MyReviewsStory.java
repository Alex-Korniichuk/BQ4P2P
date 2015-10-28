package com.qamadness.features;

/**
 * Created by alexandrakorniichuk on 13.10.15.
 */
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
public class MyReviewsStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Steps
    public ProductDetailsPageSteps productDetailsPageSteps;

    @Steps
    public MyReviewsPageSteps myReviewsPageSteps;

    @Issue("AUT-42")

    @Pending @Test
    public void add_new_review_for_a_product (){
        String reviewSummary = "Robot Test Review";
        String review = "This is my Robot test review for the products. Please remove it after test.";
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_Product_And_Services_Tab();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.open_Product_Details_Page();
        String expectedProductName = productDetailsPageSteps.get_Expected_Product_Name();
        productDetailsPageSteps.click_Write_Review_Link();
        productDetailsPageSteps.select_5_Stars_Price_Rating();
        productDetailsPageSteps.select_4_Stars_Value_Rating();
        productDetailsPageSteps.select_3_Stars_Quality_Rating();
        productDetailsPageSteps.enter_Review_Summary(reviewSummary);
        productDetailsPageSteps.enter_Review(review);
        productDetailsPageSteps.submit_Review();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_My_Reviews_Page();
        myReviewsPageSteps.check_Product_Name(expectedProductName);
        myReviewsPageSteps.check_Review_Summary(reviewSummary);
        myReviewsPageSteps.check_Review(review);
    }
}
