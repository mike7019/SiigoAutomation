package com.co.siigo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target SHADOW_USERNAME = Target.the("field for username")
            .locatedBy("#username");
    public static final Target TXT_USERNAME = Target.the("field for username")
            .locatedBy("#username-input");
    public static final Target SHADOW_PASSWORD = Target.the("field for username")
            .locatedBy("#current-password");
    public static final Target TXT_PASSWORD = Target.the("field for password")
            .locatedBy("//input[@id='password-input']");
    public static final Target BTN_SUBMIT = Target.the("button to login")
            .locatedBy("//button[@id='login-submit']");

}
