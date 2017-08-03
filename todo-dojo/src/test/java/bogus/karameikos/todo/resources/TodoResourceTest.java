package bogus.karameikos.todo.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class TodoResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
    	System.setProperty("jersey.config.test.container.port", "9152");
        return new ResourceConfig(TodoResource.class);
    }

    @Test
    public void testSize() {
        final int size = target("todo/size").request().get(Integer.class);
        Assert.assertEquals("Size should return 3", 3, size);
    }
    
    @Test
    public void testRemove() {
        final int sizeDavor = target("todo/size").request().get(Integer.class);
    	target("todo/1").request().delete();
        final int sizeDanach = target("todo/size").request().get(Integer.class);
        Assert.assertTrue("Eintrag wurde nicht gelöscht.", sizeDanach < sizeDavor);
    }

    @Test
    public void testRemoveNichtExistent() {
        final int sizeDavor = target("todo/size").request().get(Integer.class);
    	target("todo/9999").request().delete();
        final int sizeDanach = target("todo/size").request().get(Integer.class);
        Assert.assertEquals("Die Liste ist kleiner geworden.", sizeDavor, sizeDanach);
    }

}