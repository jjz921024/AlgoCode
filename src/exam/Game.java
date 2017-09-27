package exam;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Jun on 2017/9/16.
 */
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            HashMap<String, Integer> map = new HashMap<>();

            while (--n >= 0) {
                map.put(scanner.next(), null);
            }
            for (int i=0; i<n*(n-1)/2; i++) {
                String s = scanner.next();
                String[] part = s.split(" ");
                String[] team = part[0].split("-");
                String[] score = part[1].split(":");
                if (Integer.parseInt(score[0]) > Integer.parseInt(score[1])) {
                    map.put(team[0], map.get(team[0])+3);
                } else if(Integer.parseInt(score[0]) < Integer.parseInt(score[1])) {
                    map.put(team[1], map.get(team[1])+3);
                } else {
                    map.put(team[0], map.get(team[0])+1);
                    map.put(team[1], map.get(team[1])+1);
                }
            }

            //将map.entrySet()转换成list
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                //降序排序
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    //return o1.getValue().compareTo(o2.getValue());
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            int count = 0;
            for (Map.Entry<String, Integer> mapping : list) {
                count++;
                if(count < n*(n-1)/2) {
                    System.out.println(mapping.getKey());
                }

            }
        }
    }
}
