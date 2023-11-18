package tvnz.interview.challange.ui.pages;

import tvnz.interview.challange.ui.dto.pages.RegistrationPageDto;

public interface RegistrationPage
{
    String readError();
    void registerUser(RegistrationPageDto pageDetails);
}
