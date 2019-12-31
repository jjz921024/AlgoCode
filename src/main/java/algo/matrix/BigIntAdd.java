package algo.matrix;

public class BigIntAdd {

    // 两个大整数相加
    public static String add(String num1, String num2) {
        // 用数组逆序存储两个整数，数组长度等于较大整数数位+1
        int maxLength = num1.length() > num2.length() ? num1.length() + 1 : num2.length() + 1;
        int[] arr1 = new int[maxLength];
        for (int i = 0; i < num1.length(); i++) {
            arr1[i] = num1.charAt(num1.length() - 1 - i) - '0'; // 转成int型
        }
        int[] arr2 = new int[maxLength];
        for (int i = 0; i < num2.length(); i++) {
            arr2[i] = num2.charAt(num2.length() - 1 - i) - '0';
        }

        // 遍历数组，按位相加
        boolean step = false; // 进位
        for (int i = 0; i < maxLength; i++) {
            arr2[i] += arr1[i];
            if (step) {
                arr2[i]++;
                step = false;
            }
            if (arr2[i] >= 10) {
                arr2[i] %= 10;
                step = true;
            }
        }

        // 返回结果, 逆序
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            sb.append(arr2[arr2.length - 1 - i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(add("1", "9876543210"));
    }
}
