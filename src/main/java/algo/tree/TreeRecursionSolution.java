package algo.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过递归解决树的相关问题
 */
public class TreeRecursionSolution {

  /**
   * 求二叉树的深度
   * leetcode 104
   */
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  /**
   * 判断两个树是否相同
   * leetcode 100
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // 先与再或，要么都为null，要么只其中一个为null  todo
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;

    // 都不为null的情况
    // 判断主要逻辑，值是否相等， 再判断左右子树
    if (p.val != q.val) return false;
    else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  /**
   * leetcode 226
   * 翻转二叉树
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    // 子节点翻转
    TreeNode left = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(left);
    // 返回头
    return root;
  }

  /**
   * leetcode 617
   * 合并两颗二叉树
   */
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) return t2;
    if (t2 == null) return t1;
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  /**
   * 判断二叉树是否镜像对称
   * 1. 它们的两个根结点具有相同的值
   * 2. 每个树的右子树都与另一个树的左子树镜像对称
   * leetcode 101
   */
  public boolean isSymmetric(TreeNode root) {
    return check(root, root);
  }

  private boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;

    return (p.val == q.val) && check(p.left, q.right) && check(p.right, q.left);
  }


  /**
   * leetcode 110
   * 判断树是否是平衡的二叉树
   *
   * 有个类似全局变量的时候，都要多写一个方法来递归
   */
  private boolean result = true;

  public boolean isBalanced(TreeNode root) {
    maxDepthHelper(root);
    return result;
  }

  private int maxDepthHelper(TreeNode root) {
    if (root == null) return 0;
    int right = maxDepthHelper(root.right);
    int left = maxDepthHelper(root.left);
    if (Math.abs(right - left) > 1) {
      result = false;
    }
    return 1 + Math.max(right, left);
  }

  /**
   * 求树的最小深度, 根到最近叶子节点的深度
   * leetcode 111
   */
  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    if (root.left == null && root.right == null) return 1;

    int min = Integer.MAX_VALUE;
    if (root.left != null) {
      min = Math.min(min, minDepth(root.left));
    }
    if (root.right != null) {
      min = Math.min(min, minDepth(root.right));
    }
    return min + 1;
  }

  /**
   * leetcode 543
   * 求二叉树的直径，可以不经过根节点
   * 搜索每个节点的 左子树深度 + 右子树深度，求最大值
   */
  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return max;
  }

  private int depth(TreeNode root) {
    if (root == null) return 0;
    int l = depth(root.left);
    int r = depth(root.right);
    max = Math.max(max, l + r);
    // 返回左右子树中最大的高度
    return Math.max(l, r) + 1;
  }

  /**
   * 打印出二叉树从根到叶子的所有路径
   * leetcode 257
   */
  public List<String> binaryTreePaths(TreeNode root) {
    // 最好用linkedList
    ArrayList<String> list = new ArrayList<>();
    if (root == null) return list;

    appendPath(root, "", list);
    return list;
  }

  private void appendPath(TreeNode node, String parent, List<String> list) {
    // 先拼接自己的value
    String current = parent + node.val;
    // 终止条件
    if (node.left == null && node.right == null) {
      list.add(current);
      return;
    }

    if (node.left != null) {
      appendPath(node.left, current + "->", list);
    }

    if (node.right != null) {
      appendPath(node.right, current + "->", list);
    }
  }

  /**
   * 将有序数组转为二叉搜索树
   * leetcode 108
   * todo 重点
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) return null;

    // 注意数组下标
    return genTree(nums, 0, nums.length - 1);
  }

  private TreeNode genTree(int[] nums, int from, int to) {
    // 重要，递归退出条件
    if (from > to) {
      return null;
    }
    // 向下取整
    int mid = (from + to) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = genTree(nums, from, mid - 1);
    node.right = genTree(nums, mid + 1, to);
    return node;
  }

  /**
   * 叶子节点相似的树
   * leetcode 872
   */
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> leafs1 = new ArrayList<>();
    ArrayList<Integer> leafs2 = new ArrayList<>();
    preOrder(root1, leafs1);
    preOrder(root2, leafs2);

    if (leafs1.size() != leafs2.size()) {
      return false;
    }
    for (int i = 0; i < leafs1.size(); i++) {
      if (!leafs1.get(i).equals(leafs2.get(i))) {
        return false;
      }
    }
    return true;
  }

  // 前序遍历添加所有的叶子节点
  private void preOrder(TreeNode node, List<Integer> list) {
    if (node == null) return;

    if (node.left == null && node.right == null) {
      list.add(node.val);
    }

    preOrder(node.left, list);
    preOrder(node.right, list);
  }

  /**
   * 返回二叉搜索树的中2个节点的公共祖先
   * leetcode 235
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 两个节点分别在根节点两边的情况
    if (p.val < root.val && q.val > root.val) {
      return root;
    }
    if (q.val < root.val && p.val > root.val) {
      return root;
    }

    // 有一个节点与根节点相等的情况
    if (p.val == root.val || q.val == root.val) {
      return root;
    }

    // 都在一边的情况  题目保证给点节点肯定存在于二叉树中
    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }

}
