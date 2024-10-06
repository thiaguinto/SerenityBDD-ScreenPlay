package starter.cart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCart implements Task {

    private final String product;

    public AddToCart(String product) {
        this.product = product.toLowerCase().replace(" ", "-");  // Asegura que el formato sea el correcto
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target productButton = Target.the(product + " add to cart button")
                .locatedBy("//button[@data-test='add-to-cart-{0}']")
                .of(product);  // Usa el producto con el formato correcto

        actor.attemptsTo(
                Click.on(productButton)
        );
    }

    public static Performable product(String product) {
        return instrumented(AddToCart.class, product);
    }
}
