package com.qamadness.steps.back_end_steps;

import com.qamadness.pages.back_end.RequestForQuotePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 28.10.15.
 */
public class RequestForQuotePageSteps extends ScenarioSteps {

    RequestForQuotePage requestForQuotePage;

    @Step
    public void enter_Quote_Title (String title){
        requestForQuotePage.enterQuoteTitle(title);
    }

    @Step
    public void select_Quote_Deadline (){
        requestForQuotePage.selectQuoteDeadline();
    }

    @Step
    public void select_Quote_Need_By_Date (){
        requestForQuotePage.selectQuoteNeedByDate();
    }

    @Step
    public void enter_Quote_Description (String desc){
        requestForQuotePage.enterQuoteDescription(desc);
    }

    @Step
    public void enter_Quote_Comment (String comment){
        requestForQuotePage.enterQuoteComment(comment);
    }

    @Step
    public void upload_File (){
        requestForQuotePage.uploadFile();
    }

    @Step
    public void click_Submit_Form_Button (){
        requestForQuotePage.clickSubmitFormButton();
    }

    @Step
    public String check_That_Request_Is_Created_And_Cancel_It (){
        String quoteID = requestForQuotePage.getRequestForQuoteID();
        requestForQuotePage.cancelQuoteRequest();
        return quoteID;
    }


}
