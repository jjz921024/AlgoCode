package algo.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class FindWord {

  public String[] findWords(String[] words) {
    char[] h1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
    char[] h2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
    char[] h3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : h1) { map.put(c, 1); }
    for (char c : h2) { map.put(c, 2); }
    for (char c : h3) { map.put(c, 3); }

    ArrayList<String> result = new ArrayList<>();
    for (String s : words) {
      char[] temp = s.toLowerCase().toCharArray();

      boolean flag = false;
      for (int i = 1; i < temp.length; i++) {
        if (!map.get(temp[i]).equals(map.get(temp[0]))) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        result.add(s);
      }
    }
    // 返回
    return result.toArray(new String[]{});
  }

}
