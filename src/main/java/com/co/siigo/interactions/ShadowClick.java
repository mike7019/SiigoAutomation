package com.co.siigo.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class ShadowClick implements Interaction {

    protected String jsPath;

    public ShadowClick(String jsPath) {
        this.jsPath = jsPath;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String script = "return " + jsPath;
        WebElement button = (WebElement) js.executeScript(script);
        button.click();
    }

    public static ShadowClick andClick() {
        return Instrumented.instanceOf(ShadowClick.class).withProperties();
    }
}
