package tvnz.interview.challange.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;
import tvnz.interview.challange.ui.pages.Pages;

public class OverseasStep {
    private Pages pages;
    public OverseasStep(Pages pages)
    {
        this.pages = pages;
    }
    @Given("I am Overseas")
    public void iAmOverseas() {
    }

    @When("I Access TVNZ app")
    public void iAccessTVNZApp() {
    }

    @Then("I see an error message {string}")
    public void iSeeAnErrorMessage(String expected) {
        Assert.assertEquals(expected,pages.landingPage.readErrorMessageOnSplashScreen());
    }
}
