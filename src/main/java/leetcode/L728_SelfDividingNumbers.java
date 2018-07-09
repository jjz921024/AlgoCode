package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jun on 2018/7/9.
 */
public class L728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=left; i<=right; i++) {
            arrayList.add(i);
            String s = String.valueOf(i);
            for (char c : s.toCharArray()) {
                int tmp = Integer.parseInt(String.valueOf(c));
                if (tmp == 0 || i % tmp != 0) {
                    arrayList.remove(new Integer(i));
                    break;
                }
            }
        }
        return arrayList;
    }
}
