package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PascalsTriangle {

  // todo
  public List<List<Integer>> generate(int numRows) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>(1));

    for (int i = 1; i < numRows; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(1);

      List<Integer> prev = result.get(i - 1);
      for (int j = 1; j < prev.size(); j++) {
        list.add(list.get(j - 1) + list.get(j));
      }
    }

    Stack<Object> stack = new Stack<>();
    

    return result;
  }



}
