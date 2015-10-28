package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.ArchivedRequestsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 19.10.15.
 */
public class ArchivedRequestsPageSteps extends ScenarioSteps {

    ArchivedRequestsPage archivedRequestsPage;

    @Step
    public void search_Request_By_ID (String requestID){
        archivedRequestsPage.searchRequestByID(requestID);
    }

    @Step
    public void check_Search_Results (String expectedID){
        archivedRequestsPage.checkSearchResult(expectedID);
    }
}
