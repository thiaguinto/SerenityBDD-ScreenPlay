package starter.checkout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.targets.Target;

public class DoCheckout {

    public static Performable clickOnCheckout() {
        return Task.where("{0} clicks on checkout",
                Click.on(CheckoutPage.CHECKOUT_BUTTON)
        );
    }

    public static Performable fillDetails(String firstName, String lastName, String postalCode) {
        return Task.where("{0} enters their checkout details",
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE_FIELD)
        );
    }

    public static Performable clickOnButton(String button) {
        return Task.where("{0} clicks on " + button,
                Click.on(getButtonTarget(button))
        );
    }

    private static Target getButtonTarget(String button) {
        switch (button.toUpperCase()) {
            case "CONTINUE":
                return CheckoutPage.CONTINUE_BUTTON;
            case "FINISH":
                return CheckoutPage.FINISH_BUTTON;
            default:
                throw new IllegalArgumentException("Button not recognized: " + button);
        }
    }
}
