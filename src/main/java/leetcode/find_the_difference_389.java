package leetcode;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * Created by Jun on 2018/7/8.
 */
public class find_the_difference_389 {
    public char findTheDifference(String s, String t) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] split = s.split("");
        for (String tmp : split) {
            if (hashMap.containsKey(tmp)) {
                hashMap.put(tmp, hashMap.get(tmp)+1);
            } else {
                hashMap.put(tmp, 1);
            }
        }

        split = t.split("");
        char result = '0';
        for (String tmp : split) {
            if (!hashMap.containsKey(tmp)) {
                result = tmp.charAt(0);
            } else {
                hashMap.put(tmp, hashMap.get(tmp)-1);
                if (hashMap.get(tmp) < 1)
                    result = tmp.charAt(0);
            }
        }
        return result;
    }

    /**
     * 也可以使用异或，相同字符抵消
     */
    public char findTheDifference_better(String s, String t) {
        int result = t.charAt(s.length());
        for (int i=0; i<s.length(); i++) {
            result += s.charAt(i);
            result -= t.charAt(i);
        }
        return (char) result;
    }
}
