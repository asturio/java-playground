package bogus.karameikos.todo.server;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("api")
public class TodoApplication extends ResourceConfig {
    public TodoApplication() {
        this.packages("bogus.karameikos.todo.resources");
        this.register(MoxyJsonFeature.class);
    }
}
