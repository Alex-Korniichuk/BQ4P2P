package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.CheckoutPage;
import com.qamadness.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 15.10.15.
 */
public class CheckoutPageSteps extends ScenarioSteps {

    CheckoutPage checkoutPage;

/* ========================================= Steps for General Information tab ====================================== */
    @Step
    public void upload_File (){
        checkoutPage.uploadFile();
    }

    @Step
    public void check_That_File_Is_Uploaded(){
        checkoutPage.checkThatFileUploaded();
    }

    @Step
    public void remove_File (){
        checkoutPage.removeFile();
    }

    @Step
    public void enter_Order_Title (String title){
        checkoutPage.enterOrderTitle(title);
    }

    @Step
    public void enter_Reason_To_Buy (String reason){
        checkoutPage.enterReasonToBuy(reason);
    }

    @Step
    public void continue_To_Shipping_And_Accounting (){
        checkoutPage.clickContinueToShippingBtn();
    }


/* ======================================== Steps for Shipping & Accounting tab ===================================== */

    @Step
    public void wait_Till_Shipping_Step_Is_Uploaded (){
        checkoutPage.waitForShippingStep();
    }

    @Step
    public void select_Shipping_Address (){
        checkoutPage.selectAddress();
    }

    @Step
    public void continue_To_Approval_Chain (){
        checkoutPage.clickContinueToApprovalBtn();
    }

/* ============================================ Steps for Approval Chain tab ======================================== */

    @Step
    public void wait_Till_Approval_Chain_Step_Is_Uploaded (){
        checkoutPage.waitForApprovalStep();
    }

    @Step
    public void add_Watcher (){
        checkoutPage.clickAddWatcherBtn();
        checkoutPage.searchForPerson();
        checkoutPage.selectPerson();
    }

    @Step

    public void check_That_Watcher_Is_Added (){
        checkoutPage.checkThatWatcherIsAdded();
    }

    @Step
    public void addApprover (){
        checkoutPage.clickEditChainLink();
        checkoutPage.clickAddApprovalBtn();
        checkoutPage.searchForPerson();
        checkoutPage.selectPerson();
    }

    @Step
    public void check_That_Approver_Is_Added_To_Chain (){
        checkoutPage.checkThatApproverIsAdded();
    }

    @Step
    public void continue_To_Review (){
        checkoutPage.clickContinueToReviewBtn();
    }

/* ================================================ Steps for Review tab ============================================ */

    @Step
    public void wait_Till_Review_Step_Is_Uploaded (){
        checkoutPage.waitForReviewStep();
    }

    @Step
    public void submit_Order (){
        checkoutPage.clickSubmitBtn();
    }

/* =============================================== Steps for Success Page =========================================== */

    @Step
    public void wait_Till_Success_Page_Is_Uploaded (){
        checkoutPage.waitForSuccessPage();
    }

    @Step
    public void create_New_Order_Template (){
        checkoutPage.enterNewOrderTemplateName();
        checkoutPage.clickSaveOrderTemplateBtn();
    }

    @Step
    public String get_Request_ID (){
        return checkoutPage.getRequestID();
    }

}
