package structure.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于链表实现的LRU算法  最近最少使用
 */
public class LRUCache {

  Map<Integer, Node> map = new HashMap<>();
  private Node head;
  private Node tail;
  private int cap;

  public LRUCache(int capacity) {
    this.cap = capacity;
  }

  // 每次访问到的元素移到末尾
  // 头部的就是最近最少使用到的
  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    } else {
      remove(node);
      appendHead(node);
      return node.value;
    }
  }

  // 若缓存未满，直接插入到末尾
  // 若缓存已满，移除头部元素后再插入
  public void put(int key, int value) {
    // 先判断是否存在
    Node node = map.get(key);
    if (node != null) {
      // 更新value，放在链表最前面
      node.value = value;
      remove(node);
      appendHead(node);

    } else {
      node = new Node(key, value);
      if(map.size() < cap) {
        map.put(key, node);
        appendHead(node);

      } else {
        // 移除最老元素
        // 链表中要维护key的原因，能通过key删除map
        map.remove(tail.key);
        remove(tail);
        appendHead(node);
        map.put(key, node);
      }
    }
  }

  // 将node添加到链表头部
  private void appendHead(Node node) {
    if(head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }

  // 从链表中移除node节点
  private void remove(Node node) {
    // 没做head检查
    if (head == tail) {
      head = tail = null;
    } else {
      if (head == node) {
        head = head.next;
        head.prev = null;
      } else if (tail == node) {
        tail = tail.prev;
        tail.next = null;

        // 这句不要也行
        node.prev = null;

      } else {
        // node为链表中要删除的节点
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
      }
    }
  }

  class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }


}
