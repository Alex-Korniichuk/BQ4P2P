package com.qamadness.steps;

import com.qamadness.pages.front_end.PendingRequestDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 19.10.15.
 */
public class PendingRequestDetailsPageSteps extends ScenarioSteps {

    PendingRequestDetailsPage pendingRequestDetailsPage;

    @Step
    public void withdraw_Pending_Request (){
        pendingRequestDetailsPage.clickWithdrawRequestBtn();
        pendingRequestDetailsPage.clickConfirmWithdrawBtn();
    }
}
