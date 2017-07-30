package bogus.karameikos.todo.server;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class TodoApplication extends ResourceConfig {
    public TodoApplication() {
        this.packages("bogus.karameikos.todo.resources");
        this.register(MoxyJsonFeature.class);
    }
}
