package bogus.karameikos.hanoi;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HanoiTest {

    @Test
    @Disabled("Not implemented yet")
    public void testEmptyStack() {
        Stack stack = new Stack();
        assertEquals("Empty Stack", "|-----", stack.toString());
    }

    @Test
    @Disabled("Not implemented")
    public void testFilledStack() {
        Stack stack = new Stack(4);
        assertEquals("Empty Stack", "|4321-", stack.toString());

        stack = new Stack(3);
        assertEquals("Empty Stack", "|321--", stack.toString());
    }
}
