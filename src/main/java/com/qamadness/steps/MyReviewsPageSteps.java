package com.qamadness.steps;

import com.qamadness.pages.front_end.HomePage;
import com.qamadness.pages.front_end.MyReviewsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 13.10.15.
 */
public class MyReviewsPageSteps extends ScenarioSteps {

    MyReviewsPage reviewsPage;

    @Step
    public void check_Product_Name (String expectedProductName){
        reviewsPage.checkProductName(expectedProductName);
    }

    @Step
    public void check_Review_Summary (String expectedSummary){
        reviewsPage.checkReviewSummary(expectedSummary);
    }

    @Step
    public void check_Review (String expectedReview){
        reviewsPage.checkReview(expectedReview);
    }
}
