package bogus.karameikos.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class HelloWorldApplication extends WebApplication {

    public HelloWorldApplication() {

    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HelloWorld.class;
    }
}
