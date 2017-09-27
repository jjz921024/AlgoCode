package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/10.
 */
public class ArrXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            int[] flag = new int[num];
            for (int i = 0; i < num; i++) {
                // 先将0找出，并置-1
                if (arr[i] == 0) {
                    flag[i] = -1;
                    count++;
                } else {
                    int temp = arr[i];
                    // 从i向前遍历
                    for (int j = i - 1; j >= 0; j--) {
                        // 遇到-1退出
                        if (flag[j] == -1) {
                            break;
                        }
                        // 遍历异或到0就算一个最短区间， 要求k的最大值
                        // 否则一直异或
                        if ((temp ^ arr[j]) == 0) {
                            flag[i] = -1;
                            count++;
                            break;
                        } else {
                            temp = temp ^ arr[j];
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}