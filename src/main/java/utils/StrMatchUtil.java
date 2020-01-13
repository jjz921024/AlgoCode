package utils;

import java.util.Random;

public class StrMatchUtil {

    private int index;

    private Random random = new Random();

    /**
     * 模式串插入位置随机
     *
     * @param length  主串长度 (不包含模式串长度，纯英文小写字母)
     * @param pattern 模式串 (用特色字符)
     * @return 返回拼接后的字符串
     */
    public String create(int length, String pattern) {
        index = random.nextInt(length);
        StringBuilder sb = new StringBuilder(length + pattern.length());
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (int) (Math.random() * 26)));
        }

        sb.insert(index, pattern);
        return sb.toString();
    }

    public boolean isMatch(int index) {
        return this.index == index;
    }

}
