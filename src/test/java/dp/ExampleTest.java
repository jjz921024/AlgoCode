package dp;

import algo.dp.Example;
import org.junit.Test;

public class ExampleTest {

    @Test
    public void testNormal() {
        System.out.println(new Example().normalFib(40));
    }

    @Test
    public void testDp() {
        System.out.println(new Example().dpFib(40));
    }


    @Test
    public void testDp2() {
        System.out.println(new Example().dpFib2(40));
    }
}
