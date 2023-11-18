package tvnz.interview.challange.ui.dto;

import io.netty.util.internal.StringUtil;

public class AccountDetails extends BaseDto
{
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) {

        if(StringUtil.isNullOrEmpty(email))
        {
            this.email = getFaker().internet().emailAddress();
            return;
        }
        this.email = returnDefaultString(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(StringUtil.isNullOrEmpty(password))
        {
            this.password = getFaker().internet().password();
            return;
        }
        this.password = returnDefaultString(password);
    }

    private String email;
    private String password;

}