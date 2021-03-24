package algo.array;

public class RotateSolution {

  /**
   * leetcode 189 旋转数组
   */
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] temp = new int[n];

    for(int i=0; i<n; i++) {
      // 使用额外数组，将原数组元素放置对应位置
      temp[(i+k)%n] = nums[i];
    }
    System.arraycopy(temp, 0, nums, 0, n);
  }

  /**
   * 方法二：多次翻转原数组
   */
  public void rotate2(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start += 1;
      end -= 1;
    }
  }


  // todo
  public boolean exist(char[][] board, String s) {
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[0].length; j++) {
        if(search(board, i, j, s, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean search(char[][] board, int i, int j, String s, int idx) {
    if(idx == s.length()) return true;

    if(i>=0 && i<board.length
      && j>=0 && j<board[0].length
      && idx < s.length() && board[i][j] == s.charAt(idx)) {
      return search(board, i+1, j, s, idx+1)
        || search(board, i, j+1, s, idx+1)
        || search(board, i-1, j, s, idx+1)
        || search(board, i, j-1, s, idx+1);
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    char[][] chars = {{'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}};
    new RotateSolution().exist(chars, "ABCB");
  }

}
