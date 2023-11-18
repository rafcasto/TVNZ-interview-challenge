package tvnz.interview.challange.ui.customs;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;
import tvnz.interview.challange.ui.controllers.BrowserStackController;
import tvnz.interview.challange.ui.controllers.MobileAndroidController;
import tvnz.interview.challange.ui.controllers.SauceLabsController;
import tvnz.interview.challange.ui.helpers.ReadConfigHelper;
import tvnz.interview.challange.ui.pages.mobile.android.LandingAndroidPage;
import tvnz.interview.challange.ui.pages.mobile.android.RegistrationAndroidPage;

public class CustomPicoFactory implements ObjectFactory
{
    private PicoFactory delegate = new PicoFactory();
    ReadConfigHelper helper = new ReadConfigHelper();
    public CustomPicoFactory(){
        remoteDriverInitializerWhenEnable();
        pojoInitializer(helper.readAppiumPlatform());
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }

    private void pojoInitializer(String platform){
        switch (platform.toUpperCase())
        {
            case "ANDROID" : androidInitializer();break;
            case "IOS": iosInitializer();break;
            case "WEB":webInitializer();break;
            default: throw new RuntimeException("Invalid option");
        }
    }

    private void remoteDriverInitializerWhenEnable(){
        if(!helper.readRunOnLocal()){
            addClass(SauceLabsController.class);
        }
    }

    private void webInitializer(){
        throw new RuntimeException("Feature under development");
    }
    private void iosInitializer(){
        throw new RuntimeException("Feature under development");
    }


    private void androidInitializer()
    {
        if(helper.readRunOnLocal())
        {
            addClass(MobileAndroidController.class);
        }
        addClass(LandingAndroidPage.class);
        addClass(RegistrationAndroidPage.class);
    }
}
