package com.qamadness.steps;

import com.qamadness.pages.front_end.ProductDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 08.10.15.
 */
public class ProductDetailsPageSteps extends ScenarioSteps {

    ProductDetailsPage productDetailsPage;

    @Step
    public void add_Product_To_Order_Template (){
        productDetailsPage.openOrderTemplateDropDown();
        productDetailsPage.addProductToTemplate();
    }
    @Step
    public String get_Expected_Product_Name (){
        return productDetailsPage.getProductName();
    }

    @Step
    public void click_Write_Review_Link (){
        productDetailsPage.clickWriteReviewLink();
    }

    @Step
    public void select_5_Stars_Price_Rating (){
        productDetailsPage.selectPriceRating();
    }

    @Step
    public void select_4_Stars_Value_Rating (){
        productDetailsPage.selectValueRating();
    }

    @Step
    public void select_3_Stars_Quality_Rating (){
        productDetailsPage.selectQualityRating();
    }

    @Step
    public void enter_Review_Summary (String reviewSummary){
        productDetailsPage.enterReviewSummary(reviewSummary);
    }

    @Step
    public void enter_Review (String review){
        productDetailsPage.enterReview(review);
    }

    @Step
    public void submit_Review (){
        productDetailsPage.clickSubmitReviewBtn();
    }

    @Step
    public void click_Add_Tag_Button() {productDetailsPage.clickAddTagBtn();}

    @Step
    public void enter_Tag_Name() {productDetailsPage.enterTagName();}

    @Step
    public void click_Add_Tag_Confirm_Button() {productDetailsPage.clickAddTagConfirmBtn();}

}
