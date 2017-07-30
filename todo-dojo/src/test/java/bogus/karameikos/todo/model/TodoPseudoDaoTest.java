package bogus.karameikos.todo.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TodoPseudoDaoTest {
    private TodoPseudoDao cut;

    @Before
    public void setUp() {
        cut = new TodoPseudoDao();
    }

    @Test
    public void testSize() {
        Assert.assertEquals("At the beginning there shouldn't be any entries.", 0, cut.size());
    }

    @Test
    public void testInsertNull() {
        cut.add(null);
        Assert.assertEquals("Null should not be added.", 0, cut.size());
    }

    @Test
    public void testSizeAfter1Insert() {
        final Todo todo = new Todo();
        todo.setName("testSizeAfter1Insert");
        cut.add(todo);
        Assert.assertEquals("Size after inserting one element should be 1.", 1, cut.size());
    }

    @Test
    public void testAddCreatesId() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setName("Todo1");
        cut.add(todo);
        Assert.assertNotEquals("ID cannot be 0.", 0, todo.getId());
        Todo todo2 = new Todo();
        todo.setName("Todo2");
        cut.add(todo2);
        Assert.assertNotEquals("ID cannot be 0.", 0, todo2.getId());
        Assert.assertNotEquals("Two different IDs should be different.", todo.getId(), todo2.getId());
    }

    @Test
    public void testGetAll() {
        List<Todo> all = cut.getAll();
        Assert.assertNotNull("There must be always a list.", all);
        // TODO:2017-07-31:claudio.clemens:Test more
    }

}