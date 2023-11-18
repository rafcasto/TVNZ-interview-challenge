package tvnz.interview.challange.ui.dto;

import io.netty.util.internal.StringUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

public class PersonalDetails extends BaseDto
{
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(StringUtil.isNullOrEmpty(firstName))
        {
            this.firstName = getFaker().name().firstName();
            return;
        }
        this.firstName = returnDefaultString(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(StringUtil.isNullOrEmpty(lastName)){
            this.lastName = getFaker().name().lastName();
            return;
        }
        this.lastName = returnDefaultString(lastName);
    }

    public String getYearOfBirth() {

        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth)
    {
        if(StringUtil.isNullOrEmpty(yearOfBirth)){
            LocalDateTime birthday = getFaker().date().birthday().toLocalDateTime();
            this.yearOfBirth =  Year.from(birthday).toString();
            return;
        }
        this.yearOfBirth = returnDefaultString(yearOfBirth);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(StringUtil.isNullOrEmpty(gender)){
            this.gender = "Diverse";
            return;
        }
        this.gender = returnDefaultString(gender);
    }

    private String firstName;
    private String lastName;
    private String yearOfBirth;
    private String gender;

    public void UpdateUserProfile()
    {

    }

}
