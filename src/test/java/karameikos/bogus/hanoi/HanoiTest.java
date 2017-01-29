package karameikos.bogus.hanoi;

import org.junit.Assert;
import org.junit.Test;


public class HanoiTest {

    @Test
    public void testEmptyStack() {
        Stack stack = new Stack();
        Assert.assertEquals("Empty Stack", "|-----", stack.toString());
    }
}
