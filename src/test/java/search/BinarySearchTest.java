package search;

import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {

  public void testBinarySearchLeft() {
    int[] arr = new int[]{1,2,2,2,5,6};
    assertEquals(BinarySearch.binarySearchLeft(arr, 2), 1);
  }

  public void testBinarySearchRight() {
    int[] arr = new int[]{1,2,2,2,5,6};
    assertEquals(BinarySearch.binarySearchRight(arr, 2), 3);
  }
}