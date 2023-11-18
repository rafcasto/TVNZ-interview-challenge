package tvnz.interview.challange.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tvnz.interview.challange.ui.controllers.MobileController;
import tvnz.interview.challange.ui.dto.AccountDetails;
import tvnz.interview.challange.ui.dto.HouseRules;
import tvnz.interview.challange.ui.dto.PersonalDetails;
import tvnz.interview.challange.ui.dto.pages.RegistrationPageDto;
import tvnz.interview.challange.ui.pages.Pages;

public class RegistrationSteps {
    Pages pages;
    AccountDetails accountDetails;
    PersonalDetails personalDetails;

    HouseRules houseRules;
    public RegistrationSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("I am a New Zealand resident")
    public void iAmANewZealandResident() {
    }

    @And("I want to register to TVNZ app")
    public void iWantToRegisterToTVNZApp() {
        pages.landingPage.navigateToSignUpPage();
    }

    @And("I provide my account details")
    public void iProvideMyAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    @And("I provide my personal details")
    public void iProvideMyPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    @And("I agree to the house rules")
    public void iAgreeToTheHouseRules(HouseRules houseRules) {
        this.houseRules = houseRules;
    }

    @When("I sign up to TVNZ")
    public void iSignUpToTVNZ() {
        pages.registrationPage.registerUser(new RegistrationPageDto(){{
            setAccountDetails(accountDetails);
            setPersonalDetails(personalDetails);
            setHouseRules(houseRules);
        }});
    }




    @Then("I see the following error message {string}")
    public void iSeeTheFollowingErrorMessage(String expected) {
        Assert.assertEquals(expected,pages.registrationPage.readError());
    }
}
