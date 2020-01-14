import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.StrMatchUtil;

import static algo.string.StringMatch.*;

public class StrMatchTest {

    private static StrMatchUtil matchUtil;
    private static String pattern;
    @BeforeClass
    public static void init() {
        matchUtil = new StrMatchUtil();
        pattern = "&%^*^$$$$$$$$$$$$$***********************************((((((((($$$$$$$$$^^^^^^^^^^^^^^^^^*****************############";
    }

    @Test
    public void testBF() {
        for (int i = 0; i < 10000; i++) {
            String s = matchUtil.create(1000, pattern);
            Assert.assertTrue(matchUtil.isMatch(matchByBF(s, pattern)));
        }
    }

    @Test
    public void testRK() {
        for (int i = 0; i < 10000; i++) {
            String s = matchUtil.create(1000, pattern);
            Assert.assertTrue(matchUtil.isMatch(matchByRK(s, pattern)));
        }
    }

    @Test
    public void testSunday() {
        for (int i = 0; i < 10000; i++) {
            String s = matchUtil.create(1000, pattern);
            Assert.assertTrue(matchUtil.isMatch(matchBySunday(s, pattern)));
        }
    }
}
