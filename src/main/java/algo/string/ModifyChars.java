package algo.string;

/**
 * Created by Jun on 2017/8/30.
 * 调整字符数组
 */
public class ModifyChars {

    /**
     * 使字符数组中数组放在右半区, 不能改变原数组中数字的顺序
     * trick: 倒着遍历数组，因为要将字符放在右半区
     */
    public static void modifyChars(char[] chars) {
        int j = chars.length-1;
        for (int i=chars.length-1; i>-1; i--) {
            if (chars[i] != '*')
                chars[j--] = chars[i];
        }
        for (;j>-1;) {
            chars[j--] = '*';
        }
    }

    public static void main(String[] args) {
        char[] chars = {'2', '4', '*', '9', '*', '0'};
        modifyChars(chars);
        System.out.println(chars);
    }
}
