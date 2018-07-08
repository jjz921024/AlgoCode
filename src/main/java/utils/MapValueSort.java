package utils;

import java.util.*;

/**
 * Created by Jun on 2017/9/17.
 */
public class MapValueSort {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("c", 0);
        map.put("d", 4);
        map.put("b", 23);

        /**
         * HashMap遍历时与添加的顺序无关
         * 可用LinkedHashMap实现按添加顺序遍历， LinkedHashSet相同
         */
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "-->" + next.getValue());
        }



        //将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
                //return o2.getValue().compareTo(o1.getValue()); //降序排序   o2小于01返回-1
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }
}