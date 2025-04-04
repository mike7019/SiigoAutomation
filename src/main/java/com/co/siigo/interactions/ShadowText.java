package com.co.siigo.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class ShadowText implements Interaction {

    protected String string;
    protected Target shadowElement;
    protected String idElement;

    public ShadowText(String string, Target shadowElement, String idElement) {
        this.string = string;
        this.shadowElement = shadowElement;
        this.idElement = idElement;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement shadowHost = shadowElement.resolveFor(actor);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector(idElement));
        shadowContent.sendKeys(string);
    }

    public static ShadowText andWrite(String string, Target shadowElement, String idElement) {
        return Instrumented.instanceOf(ShadowText.class).withProperties(string, shadowElement, idElement);
    }

}
