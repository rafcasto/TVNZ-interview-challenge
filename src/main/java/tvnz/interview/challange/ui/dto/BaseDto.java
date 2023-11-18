package tvnz.interview.challange.ui.dto;

import net.datafaker.Faker;
import tvnz.interview.challange.ui.pages.mobile.android.BaseAndroidPage;

public class BaseDto
{
   private Faker faker;
    public BaseDto(){
        faker = new Faker();
    }


    public Faker getFaker(){
        return  faker;
    }

    public String returnDefaultString(String value){
        if(value.equals("BLANK"))
        {
            return null;
        }
        return value;
    }
}
