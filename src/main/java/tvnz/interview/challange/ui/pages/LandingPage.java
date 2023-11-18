package tvnz.interview.challange.ui.pages;

public interface LandingPage
{
    void navigateToSignInPage();
    void navigateToSignUpPage();

    String readErrorMessageOnSplashScreen();
}
