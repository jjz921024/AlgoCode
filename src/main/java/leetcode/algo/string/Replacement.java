package leetcode.algo.string;

/**
 * Created by Jun on 2017/7/31.
 *
 */
public class Replacement {

    /**
     * 将字符串中的空格用 %20 代替
     */
    public String replaceSpace1(String iniString, int length) {
        char[] chars = iniString.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                count++;
        }
        // 新的字符数组长度需要增加
        char[] newchs = new char[length + count * 2];
        count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i + count * 2] == ' ') {
                newchs[i] = '%';
                newchs[i+1] = '2';
                newchs[i+2] = '0';
                count++;
            } else {
                newchs[i + count * 2] = chars[i + count * 2];
            }
        }
        return new String(newchs);
    }


    public String replaceSpace2(String iniString, int length) {
        StringBuilder sb = new StringBuilder();
        String rep = "%20";
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' ') {
                sb.append(rep);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
