package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 706
 * 不使用内建哈希结构设计一个哈希表
 */
public class MyHashMap {

  private final List<Node>[] array;

  public MyHashMap() {
    array = new ArrayList[16];
    for (int i = 0; i < array.length; i++) {
      array[i] = new ArrayList<>();
    }
  }

  // 存在则更新
  public void put(int key, int value) {
    Node node = new Node(key, value);
    List<Node> list = array[key % 16];
    for (Node n : list) {
      if (key == n.k) {
        n.v = value;
        return;
      }
    }
    list.add(node);
  }

  // 返回key对应的值，不存在返回-1
  public int get(int key) {
    List<Node> list = array[key % 16];
    for (Node n : list) {
      if (n.k == key) {
        return n.v;
      }
    }
    return -1;
  }

  // 如果存在则删除key
  public void remove(int key) {
    List<Node> list = array[key % 16];
    list.removeIf(n -> n.k == key);
  }

  class Node {
    int k, v;

    public Node(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }

}
