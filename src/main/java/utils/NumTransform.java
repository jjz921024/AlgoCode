package utils;

/**
 * Created by Jun on 2017/9/21.
 * 十进制转n进制
 */
public class NumTransform {
    //num为输入十进制数，n为要转换的进制
    public static void transform(int num, int n){
        int array[]=new int[100];
        int location=0;
        //当输入的数不为0时循环执行求余和赋值
        while(num != 0){
            array[location++] = num%n;  //余数放入数组
            num = num/n;
        }

        for(int i=location-1; i>=0; i--){
            if(array[i] > 9){
                /*
                  转换为字母
                  例如 15在16进制下为F
                  A的码值65， 65-10为55
                 */
                System.out.print((char)(array[i] + 55));
            } else
                System.out.print(array[i]);
        }

    }

}
