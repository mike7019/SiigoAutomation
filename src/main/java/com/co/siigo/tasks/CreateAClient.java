package com.co.siigo.tasks;

import com.co.siigo.interactions.InteractWithShadownELement;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.siigo.userinterfaces.LoginPage.SHADOW_USERNAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateAClient implements Task {
    public static final Target TXT_USERNAME = Target.the("")
            .locatedBy("");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                InteractWithShadownELement.on("username", SHADOW_USERNAME, "#username-input"));
    }

    public static CreateAClient onTheSite(){
        return Instrumented.instanceOf(CreateAClient.class).withProperties();
    }
}
