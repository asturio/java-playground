package bogus.karameikos.todo.server;

import bogus.karameikos.todo.resources.TodoResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server {
    public static final String BASE_URI = "http://localhost:8090/api";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages(TodoResource.class.getPackage().getName());
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String... args) throws IOException {
        final HttpServer server = startServer();
        System.out.format("Jersey app started with WADL available at %s/application.wadl\n"
                + "Hit enter to stop it...", BASE_URI);
        System.in.read();
        server.shutdown();
    }
}
