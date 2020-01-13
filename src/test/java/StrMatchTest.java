import org.junit.Assert;
import org.junit.Test;
import utils.StrMatchUtil;

import static algo.string.StringMatch.matchByBF;
import static algo.string.StringMatch.matchByRK;

public class StrMatchTest {

    @Test
    public void testBF() {
        for (int i = 0; i < 100; i++) {
            StrMatchUtil matchUtil = new StrMatchUtil();
            String s = matchUtil.create(10000, "&&((*&");
            Assert.assertTrue(matchUtil.isMatch(matchByBF(s, "&&((*&")));
        }
    }

    @Test
    public void testRK() {
        for (int i = 0; i < 100; i++) {
            StrMatchUtil matchUtil = new StrMatchUtil();
            String s = matchUtil.create(10000, "!!!");
            Assert.assertTrue(matchUtil.isMatch(matchByRK(s, "!!!")));
        }
    }
}
