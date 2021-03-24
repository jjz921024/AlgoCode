package utils;

public class TreeNodeWithNextPrt {

    public int val;
    public TreeNodeWithNextPrt left;
    public TreeNodeWithNextPrt right;
    public TreeNodeWithNextPrt next;

    public TreeNodeWithNextPrt() {}

    public TreeNodeWithNextPrt(int _val) {
      val = _val;
    }

    public TreeNodeWithNextPrt(int _val, TreeNodeWithNextPrt _left, TreeNodeWithNextPrt _right, TreeNodeWithNextPrt _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }

}
