package com.qamadness.steps;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */

import com.qamadness.pages.front_end.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class QuickOrderPageSteps extends ScenarioSteps{

    QuickOrderPage quickOrderPage;

    @Step
    public void upload_File (){
        quickOrderPage.uploadFile();
    }



}
