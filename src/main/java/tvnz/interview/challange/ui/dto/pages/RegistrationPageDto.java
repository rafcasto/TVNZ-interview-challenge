package tvnz.interview.challange.ui.dto.pages;

import tvnz.interview.challange.ui.dto.AccountDetails;
import tvnz.interview.challange.ui.dto.HouseRules;
import tvnz.interview.challange.ui.dto.PersonalDetails;

public class RegistrationPageDto
{
    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public HouseRules getHouseRules() {
        return houseRules;
    }

    public void setHouseRules(HouseRules houseRules) {
        this.houseRules = houseRules;
    }

    private HouseRules houseRules;

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    private AccountDetails accountDetails;
    private PersonalDetails personalDetails;

}
