package karameikos.bogus.hanoi;

import org.junit.Assert;
import org.junit.Test;


public class HanoiTest {

    @Test
    public void testEmptyStack() {
        Stack stack = new Stack();
        Assert.assertEquals("Empty Stack", "|-----", stack.toString());
    }

    @Test
    public void testFilledStack() {
        Stack stack = new Stack(4);
        Assert.assertEquals("Empty Stack", "|4321-", stack.toString());

        stack = new Stack(3);
        Assert.assertEquals("Empty Stack", "|321--", stack.toString());
    }
}
