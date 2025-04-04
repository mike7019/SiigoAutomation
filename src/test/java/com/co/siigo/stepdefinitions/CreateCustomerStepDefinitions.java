package com.co.siigo.stepdefinitions;

import com.co.siigo.tasks.CreateAClient;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;

import static com.co.siigo.utils.Constants.MIKE;
import static com.co.siigo.utils.Constants.URL;

public class CreateCustomerStepDefinitions {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that Mike is on the website")
    public void thatMikeIsOnTheWebsite() {
        OnStage.theActorCalled(MIKE).wasAbleTo(
                Open.url(URL)
        );
    }
    @When("he attempts to create a client")
    public void heAttemptsToCreateAClient() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateAClient.onTheSite()
        );
    }
    @Then("he will see the client created")
    public void heWillSeeTheClientCreated() {

    }

}
