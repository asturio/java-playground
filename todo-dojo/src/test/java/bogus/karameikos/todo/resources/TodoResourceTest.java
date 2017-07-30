package bogus.karameikos.todo.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class TodoResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(TodoResource.class);
    }

    @Test
    public void testSize() {
        final int size = target("todo/size").request().get(Integer.class);
        Assert.assertEquals("Size should return 3", 3, size);
    }

}