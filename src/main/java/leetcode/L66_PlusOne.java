package leetcode;

import java.util.Arrays;

public class L66_PlusOne {
    public int[] plusOne(int[] digits) {
        String[] strings = Arrays.stream(digits)
                .mapToObj(Integer::toString)
                .reduce((s1, s2) -> s1 + s2)
                .map(s -> {
                    int i = Integer.parseInt(s);
                    i += 1;
                    return Integer.toString(i);
                })
                .map(s -> s.split(""))
                .get();

        Arrays.stream(strings)
                .map(Integer::parseInt);

        return null;
    }
}
