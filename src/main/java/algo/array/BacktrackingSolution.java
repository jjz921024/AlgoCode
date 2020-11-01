package algo.array;

import java.security.Key;
import java.util.*;
import java.util.stream.Stream;

public class BacktrackingSolution {

  /**
   * leetcode 46 全排列
   * 回溯：选择列表，路径，结束条件
   */
  LinkedList<List<Integer>> result = new LinkedList<>();

  public List<List<Integer>> permute(int[] nums) {
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return result;
  }

  // nums: 选择列表  track: 路径
  private void backtrack(int[] nums, LinkedList<Integer> track) {
    // 结束条件： 路径走满
    if (nums.length == track.size()) {
      result.add(new LinkedList<>(track)); // 注意：新建一个list返回
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 过滤掉路径中已存在的元素， 没有显示记录选择列表
      if (track.contains(nums[i]))
        continue;

      track.add(nums[i]);
      backtrack(nums, track);
      track.removeLast();
    }
  }

  /**
   * leetcode 77  1-n的元素任意组合k个
   */
  LinkedList<List<Integer>> result2 = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
    LinkedList<Integer> track = new LinkedList<>();
    backtrack2(n, k, track);
    return result2;
  }

  private void backtrack2(int n, int k, LinkedList<Integer> track) {
    if (track.size() == k) {
      result2.add(new LinkedList<>(track));
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (track.contains(i))
        continue;

      track.add(i);
      backtrack2(i, k, track);
      track.removeLast();
    }
  }

  /**
   * leetcode 78
   * 不包含重复元素的数组，返回其所有子集
   */
  LinkedList<List<Integer>> result3 = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
    LinkedList<Integer> track = new LinkedList<>();
    backtrack3(0, nums, track);
    return result3;
  }

  private void backtrack3(int n, int[] nums, LinkedList<Integer> track) {
    result3.add(new LinkedList<>(track));
    for (int i = n; i < nums.length; i++) {
      track.add(nums[i]);
      backtrack3(i + 1, nums, track);  // i+1 选择列表
      track.removeLast();
    }
  }


  /**
   * leetcode 39
   * 组合总和， 无重复元素
   */
  LinkedList<List<Integer>> result4 = new LinkedList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    LinkedList<Integer> track = new LinkedList<>();
    backtrack4(target, candidates, track, 0);
    return result4;
  }

  private void backtrack4(int target, int[] nums, LinkedList<Integer> track, int start) {
    if (target < 0) return;
    if (target == 0) {
      result4.add(new LinkedList<>(track));
    }

    // note: 因为无重复元素，从start开始相当于缩小选择列表范围，能去重
    for (int i = start; i < nums.length; i++) {
      if (nums[i] > target) continue;  // 剪枝

      track.add(nums[i]);
      backtrack4(target - nums[i], nums, track, i);
      track.removeLast();
    }
  }


  /**
   * leetcode 40
   * 组合总和  与39题差别，元素只能用一次
   */
  LinkedList<List<Integer>> result5 = new LinkedList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    LinkedList<Integer> track = new LinkedList<>();
    backtrack5(target, candidates, track);
    return result5;
  }

  private void backtrack5(int target, int[] nums, LinkedList<Integer> track) {
    //todo
  }

  /**
   * leetcode 17 电话号码的字母组合
   */

  /*HashMap<Character, Character[]> map = new HashMap<Character, Character[]>() {{
    put('2', new Character[]{'a', 'b', 'c'});
    put('3', new Character[]{'d', 'e', 'f'});
    put('4', new Character[]{'g', 'h', 'i'});
    put('5', new Character[]{'j', 'k', 'l'});
    put('6', new Character[]{'m', 'n', 'o'});
    put('7', new Character[]{'p', 'q', 'r', 's'});
    put('8', new Character[]{'t', 'u', 'v'});
    put('9', new Character[]{'w', 'x', 'y', 'z'});
  }};

  LinkedList<String> res = new LinkedList<>();

  public List<String> letterCombinations(String digits) {
    if (digits == null || "".equals(digits)) return res;

    LinkedList<Character> track = new LinkedList<>();
    char[] nums = digits.toCharArray();
    backtrack2(nums, track);
    return res;
  }

  private void backtrack2(char[] nums, LinkedList<Character> track) {
    if (nums.length == track.size()) {

      return;
    }

    for (int i = 0; i < nums.length; i++) {
      Character[] chars = map.get(nums[i]);
      for (Character c : chars) {
        if (track.contains(c))
          continue;
        track.add(c);
        backtrack2(nums, track);
        track.removeLast();
      }
    }
  }*/



}
