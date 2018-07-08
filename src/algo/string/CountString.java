package algo.string;

/**
 * Created by Jun on 2017/8/30.
 * 统计字符串
 */
public class CountString {

    public static String getCountString(String str) {
        if (str == null)
            return null;
        char[] chars = str.toCharArray();

        int count = 0;
        char last = chars[0];
        String res = "";
        for (char c : chars) {
            count++;
            if (c != last) {
                res += String.valueOf(last) + "_" + String.valueOf(count) + "_";
                count = 0;
            }
            last = c;
        }
        res += String.valueOf(last) + "_" + String.valueOf(count) + "_";
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getCountString("aabbabdd3333"));
    }
}
