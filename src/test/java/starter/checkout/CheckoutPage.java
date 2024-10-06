package starter.checkout;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage  {
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.id("checkout"));
    public static final Target FIRST_NAME_FIELD = Target.the("first name field")
            .located(By.id("first-name"));
    public static final Target LAST_NAME_FIELD = Target.the("last name field")
            .located(By.id("last-name"));
    public static final Target POSTAL_CODE_FIELD = Target.the("postal code field")
            .located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .located(By.id("continue"));
    public static final Target FINISH_BUTTON = Target.the("finish button")
            .located(By.id("finish"));

    public static final Target CONFIRMATION_MESSAGE = Target.the("confirmation message")
            .locatedBy("//h2[text()='Thank you for your order!']");
}

