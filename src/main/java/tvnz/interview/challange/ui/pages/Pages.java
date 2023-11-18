package tvnz.interview.challange.ui.pages;

import io.cucumber.java8.En;

public class Pages implements En {
    public LandingPage landingPage;
    public RegistrationPage registrationPage;
    public Pages(LandingPage landingPage
                ,RegistrationPage registrationPage)
    {
        this.landingPage = landingPage;
        this.registrationPage = registrationPage;
    }
}
