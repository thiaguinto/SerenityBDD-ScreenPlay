package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import starter.cart.AddToCart;
import starter.cart.ViewCart;
import starter.checkout.CheckoutPage;
import starter.checkout.DoCheckout;
import starter.navigation.NavigateTo;
import starter.login.DoLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    private String name;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} has an active account")
    public void hasAnActiveAccount(String name) {
        this.name = name;
        System.out.println(name + " has an active account");
    }

    @When("{string} sends their valid credentials")
    public void sendsTheirValidCredentials(String name) {
        theActorCalled(name).attemptsTo(
                NavigateTo.saucedemo(),
                DoLogin.withUsernameAndPassword("standard_user", "secret_sauce")
        );
    }

    @When("{string} adds {string} and {string} to the cart")
    public void adds_and_to_the_cart(String name, String product1, String product2) {
        theActorCalled(name).attemptsTo(
                AddToCart.product(product1), // Añadir el primer producto
                AddToCart.product(product2)  // Añadir el segundo producto
        );
    }

    @And("{string} views the cart and clicks on checkout")
    public void viewsTheCartAndClicksOnCheckout(String name) {
        theActorCalled(name).attemptsTo(
                ViewCart.open(),
                DoCheckout.clickOnCheckout()
        );
    }

    @And("{string} completes the purchase with details {string}, {string}, {string}")
    public void completesThePurchaseWithDetails(String name, String firstName, String lastName, String postalCode) {
        theActorCalled(name).attemptsTo(
                DoCheckout.fillDetails(firstName, lastName, postalCode)
        );
    }

    @And("{string} completes the purchase flow by clicking on {string}, {string}")
    public void completesThePurchaseFlowByClickingOn(String name, String continueButton, String finishButton) {
        theActorCalled(name).attemptsTo(
                DoCheckout.clickOnButton(continueButton),
                DoCheckout.clickOnButton(finishButton)
        );
    }

    @Then("{string} should see the confirmation message {string}")
    public void shouldSeeTheConfirmationMessage(String name, String expectedMessage) {
        theActorCalled(name).should(
                seeThat("The confirmation message is visible",
                        WebElementQuestion.the(CheckoutPage.CONFIRMATION_MESSAGE),
                        isVisible()
                ),
                seeThat("The confirmation message text is correct",
                        (actor) -> the(CheckoutPage.CONFIRMATION_MESSAGE).answeredBy(actor).getText(),
                        containsString(expectedMessage) // Verifica que el mensaje contenga el texto esperado
                )
        );
    }



}





