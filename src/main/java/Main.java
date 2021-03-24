import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            //HashMap<String, List<Entry>> map = new HashMap<>();
            Entry[] entries = new Entry[n];
            while(n-- > 0) {
                String[] s = in.nextLine().split(" ");
                /*List<Entry> list = map.getOrDefault(s[0], new ArrayList<>());
                list.add(new Entry(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
                map.put(s[0], list);*/
                entries[n] = new Entry(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            }

            /*Set<Map.Entry<String, List<Entry>>> entries = map.entrySet();
            Iterator<Map.Entry<String, List<Entry>>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<Entry>> next = iterator.next();
                Entry[] array = next.getValue().toArray(new Entry[]{});
                Arrays.sort(array, new Comparator<Entry>() {
                    @Override
                    public int compare(Entry e1, Entry e2) {
                        if (e1.weight == e2.weight) {
                            return e1.id - e2.id;
                        }
                        return e2.weight - e1.weight;
                    }
                });

                for (Entry entry : array) {
                    System.out.println(next.getKey() + " " + entry.id + " " + entry.weigth);
                }

            }*/

            Arrays.sort(entries, new Comparator<Entry>() {
                @Override
                public int compare(Entry o1, Entry o2) {
                    if (o1.fruit.compareTo(o2.fruit) == 0) {
                        if(o1.weight == o2.weight) {
                            return o1.id - o2.id;
                        }
                        return o2.weight - o1.weight;
                    }
                    return o1.fruit.compareTo(o2.fruit);
                }
            });

            for (Entry entry : entries) {
                System.out.println(entry.fruit + " " + entry.id + " " + entry.weight);
            }


        }
    }

    static class Entry{
        String fruit;
        int id;
        int weight;

        public Entry(String fruit, int id, int weight) {
            this.fruit = fruit;
            this.id = id;
            this.weight = weight;
        }
    }





}