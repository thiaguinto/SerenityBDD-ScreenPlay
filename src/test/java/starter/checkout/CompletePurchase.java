package starter.checkout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletePurchase implements Task {

    private String firstName;
    private String lastName;
     private String postalCode;

    public CompletePurchase(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE_FIELD),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.CHECKOUT_BUTTON)
        );
    }

    public static Performable withDetails(String firstName, String lastName, String postalCode) {
        return instrumented(CompletePurchase.class, firstName, lastName, postalCode);
    }
}
