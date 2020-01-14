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
        for (int i = 0; i < str.length() - pattern.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                // 是否遍历完模式串
                if (j == pattern.length() - 1) {
                    return i;
                }
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

        for (int i = 0; i < str.length() - pattern.length(); i++) {
            String subStr = str.substring(i, i + pattern.length());
            if (strHash == patternHash && subStr.equals(pattern)) {
                return i;
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


    // BM KMP Horspool AC
    public static int matchByBM(String str, String pattern) {
        return -1;
    }


    /**
     * Sunday算法, BM的优化
     * 由前往后遍历主串，不匹配时关注主串中位于模式串后的第一个字符
     * 再在模式串中从后往前查找该字符
     * 若没有该字符，则把模式串移动到该字符后
     * 若有该字符，则移动模式串使其对齐
     *
     * 时间O(m/n), 特殊情况下会退化成O(m*n)
     * 例如 主串：aaaaaabaaaaabaaaaab  模式串：aaaaa
     * 每次失败时只向后移动一位
     */
    public static int matchBySunday(String str, String pattern) {
        for (int i = 0; i < str.length() - pattern.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    char c = str.charAt(i + pattern.length());
                    int idx;
                    if ((idx = indexOfSubstr(pattern, c)) == -1) {
                        // 不存在该字符，移动子串长度+1位
                        i += pattern.length();
                    } else {
                        // 存在时, 移动位数 = 模式串长度 - 该字符最右出现的位置(以0开始)
                        // = 模式串中该字符最右出现的位置到尾部的距离 + 1
                        i += pattern.length() - idx - 1;
                    }
                    break;
                }

                if (j == pattern.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 从后往前查找字符在字符串中出现的位置
    private static int indexOfSubstr(String str, char c) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
