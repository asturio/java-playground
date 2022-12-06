package bogus.karameikos.todo.resources;

import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodoResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(TodoResource.class);
    }

    @Test
    public void testSize() {
        final int size = target("todo/size").request().get(Integer.class);
        Assertions.assertEquals(3, size, "Size should return 3");
    }

}
