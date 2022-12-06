package bogus.karameikos.todo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TodoPseudoDaoTest {
    private TodoPseudoDao cut;

    @BeforeEach
    public void setUp() {
        cut = new TodoPseudoDao();
    }

    @Test
    public void testSize() {
        assertEquals(0, cut.size(),"At the beginning there shouldn't be any entries.");
    }

    @Test
    public void testInsertNull() {
        cut.add(null);
        assertEquals( 0, cut.size(),"Null should not be added.");
    }

    @Test
    public void testSizeAfter1Insert() {
        final Todo todo = new Todo();
        todo.setName("testSizeAfter1Insert");
        cut.add(todo);
        assertEquals(1, cut.size(),"Size after inserting one element should be 1.");
    }

    @Test
    public void testAddCreatesId() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setName("Todo1");
        cut.add(todo);
        assertNotEquals( 0, todo.getId(),"ID cannot be 0.");
        Todo todo2 = new Todo();
        todo.setName("Todo2");
        cut.add(todo2);
        assertNotEquals( 0, todo2.getId(),"ID cannot be 0.");
        assertNotEquals( todo.getId(), todo2.getId(),"Two different IDs should be different.");
    }

    @Test
    public void testGetAll() {
        List<Todo> all = cut.getAll();
        assertNotNull( all,"There must be always a list.");
    }

}
