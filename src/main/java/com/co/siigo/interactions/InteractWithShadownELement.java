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

public class InteractWithShadownELement implements Interaction {

    protected String cadena;
    protected Target idHostCSSelector;
    protected Target idContentCSSelector;

    public InteractWithShadownELement(String cadena, Target idHostCSSelector, Target idContentCSSelector) {
        this.cadena = cadena;
        this.idHostCSSelector = idHostCSSelector;
        this.idContentCSSelector = idContentCSSelector;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement shadowHost = idHostCSSelector.resolveFor(actor);
        WebElement shadowElement = idContentCSSelector.resolveFor(actor);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        SearchContext shadowContent = shadowElement.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector(idContentCSSelector));
        shadowContent.sendKeys(cadena);
    }

    public static InteractWithShadownELement on(String cadena, Target idHostCSSelector, Target idContentCSSelector) {
        return Instrumented.instanceOf(InteractWithShadownELement.class).withProperties(cadena, idHostCSSelector, idContentCSSelector);
    }

    public void clickParaElementoDentroDeShadow(String jsPath){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String script = "return " + jsPath;
        WebElement button = (WebElement) js.executeScript(script);
        button.click();


    }
}
