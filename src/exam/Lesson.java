package exam;

import java.util.*;

/**
 * Created by Jun on 2017/9/16.
 */
public class Lesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            TreeMap<String, StringBuilder> map = new TreeMap<>();
            boolean flag = false;
            while (--n >= 0) {
                String num = scanner.next();
                String lesson = scanner.next();

                if (!map.containsKey(num)) {
                    map.put(num, new StringBuilder(lesson));
                } else {
                    StringBuilder append = map.get(num).append(" " + lesson);
                    map.put(num, append);
                    flag = true;
                }
            }

            if (flag) {
                Set<Map.Entry<String, StringBuilder>> entries = map.entrySet();
                Iterator<Map.Entry<String, StringBuilder>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, StringBuilder> next = iterator.next();
                    if (next.getValue().toString().split(" ").length >= 2) {
                        System.out.println(next.getKey() + " " + next.getValue());
                    }

                }
            } else {
                System.out.println("YES");
            }

        }
    }
}
