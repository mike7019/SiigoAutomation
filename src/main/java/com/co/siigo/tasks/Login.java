package com.co.siigo.tasks;

import com.co.siigo.interactions.ShadowText;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static com.co.siigo.userinterfaces.LoginPage.*;

public class Login implements Task {
    public static final Target TXT_USERNAME = Target.the("")
            .locatedBy("");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ShadowText.andWrite("retoautomationsiigo@yopmail.com", SHADOW_USERNAME, "#username-input"),
                ShadowText.andWrite("T4b4ck0ff1c3P455w0rd658*", SHADOW_PASSWORD, "#password-input"),
                Click.on(By.id("login-submit"))
        );
    }

    public static Login onTheSite(){
        return Instrumented.instanceOf(Login.class).withProperties();
    }
}
