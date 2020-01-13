package algo.string;

/**
 * 字符串匹配算法
 * str 主串
 * pattern 模式串
 * 返回模式串在主串中第一次出现的位置，未出现返回-1
 */
public class StringMatch {

    /**
     * Brute Force(BF) 暴力算法
     * 复杂度 O(mn)
     */
    public static int matchByBF(String str, String pattern) {
        for (int i = 0; i < str.toCharArray().length; i++) {
            // 记录主串位置
            int ii = i;
            int j;
            for (j = 0; j < pattern.toCharArray().length; j++) {
                if (str.charAt(ii++) != pattern.charAt(j)) {
                    break;
                }
            }
            // 是否遍历完模式串
            if (j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Rabin-Karp(RK) 算法
     * 比较两个字符串的哈希值，哈希值相同后，为防止哈希碰撞，再逐个比较字符
     * <p>
     * 主串遍历过程中，每一个子串的hash可以由上一个字串增量计算得到
     * 因此，时间复杂度为 O(n)
     *
     * 哈希冲突几率大时，会退化成BF算法
     */
    public static int matchByRK(String str, String pattern) {
        int patternHash = hash(pattern);
        // 先对主串进行一次hash
        int strHash = hash(str.substring(0, pattern.length()));

        for (int i = 0; i < str.length(); i++) {
            String subStr = str.substring(i, i + pattern.length());
            if (strHash == patternHash && subStr.equals(pattern)) {
                return i;
            }

            if (i + pattern.length() >= str.length()) {
                break;
            }
            // 增量式hash
            strHash -= str.charAt(i) - 'a';
            strHash += str.charAt(i + pattern.length()) - 'a';
        }
        return -1;
    }

    private static int hash(String str) {
        int hashcode = 0;
        // 把a当做1，把b当中2，把c当中3.....然后按位相加
        for (int i = 0; i < str.length(); i++) {
            hashcode += str.charAt(i) - 'a';
        }
        return hashcode;
    }


    // BM KMP Sunday Horspool s
    public static int matchByBM(String str, String pattern) {
        return -1;
    }



}
