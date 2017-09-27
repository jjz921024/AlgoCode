package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jun on 2017/9/17.
 */
public class Reg {

    public static void main(String[] args) {
        String str1 = "A:B - 1:0";
        Pattern pattern = Pattern.compile("(\\w):(\\w) - (\\d):(\\d)");
        Matcher matcher = pattern.matcher(str1);  //匹配要匹配的字符串

        //System.out.println(matcher.matches());  //是否与正则匹配

        //matches 和 find只能调用一次
        if (matcher.find()) {

            System.out.println(matcher.group());
            System.out.println(matcher.group(2));
        } else {
            System.out.println("not match found");
        }
    }
}
