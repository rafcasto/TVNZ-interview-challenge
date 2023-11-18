package tvnz.interview.challange.ui.dto;

public class HouseRules
{
    private boolean agreeTermsAndConditions;

    public boolean isAgreeTermsAndConditions() {
        return agreeTermsAndConditions;
    }

    public void setAgreeTermsAndConditions(boolean agreeTermsAndConditions) {
        this.agreeTermsAndConditions = agreeTermsAndConditions;
    }

    public boolean isAgreeToReceiveUpdates() {
        return agreeToReceiveUpdates;
    }

    public void setAgreeToReceiveUpdates(boolean agreeToReceiveUpdates) {
        this.agreeToReceiveUpdates = agreeToReceiveUpdates;
    }

    private boolean agreeToReceiveUpdates;
}
