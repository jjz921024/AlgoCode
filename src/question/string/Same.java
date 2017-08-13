package question.string;

import java.util.Arrays;

/**
 * Created by Jun on 2017/7/31.
 */
public class Same {
    public static boolean checkSam(String stringA, String stringB) {
        char[] str1 = stringA.toCharArray();
        char[] str2 = stringB.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1,str2);

    }


    public static void main(String[] args) {
        System.out.println(checkSam("ab aa", "aab"));
    }
}
