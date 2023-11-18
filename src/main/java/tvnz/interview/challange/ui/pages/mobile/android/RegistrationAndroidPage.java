package tvnz.interview.challange.ui.pages.mobile.android;

import io.appium.java_client.AppiumBy;
import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import tvnz.interview.challange.ui.controllers.MobileController;
import tvnz.interview.challange.ui.dto.AccountDetails;
import tvnz.interview.challange.ui.dto.HouseRules;
import tvnz.interview.challange.ui.dto.PersonalDetails;
import tvnz.interview.challange.ui.dto.pages.RegistrationPageDto;
import tvnz.interview.challange.ui.pages.RegistrationPage;

public class RegistrationAndroidPage extends BaseAndroidPage implements RegistrationPage {
    private static By USER_EMAIL_INPUT= AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"nz.co.tvnz.ondemand.phone.android.od2test:id/input_editText\"])[1]");
    private static By USER_PASSWORD_INPUT = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"nz.co.tvnz.ondemand.phone.android.od2test:id/input_editText\"])[2]");
    private static By FIRST_NAME_INPUT = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"nz.co.tvnz.ondemand.phone.android.od2test:id/input_editText\"])[3]");
    private static By LAST_NAME_INPUT = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"nz.co.tvnz.ondemand.phone.android.od2test:id/input_editText\"])[4]");
    private static By YEAR_OF_BIRTH_INPUT = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"nz.co.tvnz.ondemand.phone.android.od2test:id/input_editText\"])[5]");
    private static By GENDER_DROPDOWN = AppiumBy.xpath("//android.widget.Spinner[@resource-id=\"nz.co.tvnz.ondemand.phone.android.od2test:id/fragment_register_gender\"]/android.widget.RelativeLayout/android.widget.ImageView");
    private static String GENDER_OPTION = "//android.widget.TextView[@text=\"%s\"]";
    private static By TERMS_AND_CONDITION_TOGGLE = AppiumBy.id("nz.co.tvnz.ondemand.phone.android.od2test:id/fragment_register_accept_tos_policies");
    private static By RECIEVE_UPDATES_TOGGLE = AppiumBy.id("nz.co.tvnz.ondemand.phone.android.od2test:id/fragment_register_option_updates");
    private static By SIGNUP_BUTTON = AppiumBy.id("nz.co.tvnz.ondemand.phone.android.od2test:id/fragment_register_btn_create_account");
    private static By ERROR_MESSAGE = AppiumBy.id("nz.co.tvnz.ondemand.phone.android.od2test:id/input_error"); 

    public RegistrationAndroidPage(MobileController controller) {
        super(controller);
    }


    @Override
    public String readError()
    {
        return readTextFromElement(ERROR_MESSAGE);
    }

    @Override
    public void registerUser(RegistrationPageDto pageDetails) {
        enterAccountDetails(pageDetails.getAccountDetails());
        enterPersonalDetails(pageDetails.getPersonalDetails());
        acceptHouseRules(pageDetails.getHouseRules());
        clickOnElement(SIGNUP_BUTTON);
    }


    private void acceptHouseRules(HouseRules houseRules){
        if(houseRules.isAgreeTermsAndConditions()){
            clickOnElement(TERMS_AND_CONDITION_TOGGLE);
        }
        if(houseRules.isAgreeToReceiveUpdates()){
            clickOnElement(RECIEVE_UPDATES_TOGGLE);
        }
    }
    private void enterPersonalDetails(PersonalDetails personalDetails)
    {
        if(!StringUtil.isNullOrEmpty(personalDetails.getFirstName()))
        {
            enterText(FIRST_NAME_INPUT,personalDetails.getFirstName());
        }
        if(!StringUtil.isNullOrEmpty(personalDetails.getLastName()))
        {
            enterText(LAST_NAME_INPUT,personalDetails.getLastName());
        }
        if(!StringUtil.isNullOrEmpty(personalDetails.getYearOfBirth()))
        {
            enterText(YEAR_OF_BIRTH_INPUT,personalDetails.getYearOfBirth());
        }if(!StringUtil.isNullOrEmpty(personalDetails.getGender())){
            selectOption(GENDER_DROPDOWN,String.format(GENDER_OPTION,personalDetails.getGender()));
        }
    }

    private void enterAccountDetails(AccountDetails accountDetails)
    {
        if(!StringUtil.isNullOrEmpty(accountDetails.getEmail()))
        {
            enterText(USER_EMAIL_INPUT,accountDetails.getEmail());
        }
        if(!StringUtil.isNullOrEmpty(accountDetails.getPassword()))
        {
            enterText(USER_PASSWORD_INPUT,accountDetails.getPassword());
        }
    }


}
