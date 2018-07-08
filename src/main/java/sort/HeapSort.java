package sort;

import org.junit.Test;
import utils.sort.ListSort;
import utils.sort.Util;

/**
 * Created by Jun on 2017/9/10.
 * 堆排序：从待排序列(从下往上，从右到左非叶结点)构建大/小顶堆，再将堆顶元素到末尾，剩余结点重新构建堆结构
 */
public class HeapSort {
    public static void heapSort(ListSort list) {
        //非叶结点构建堆
        for (int i=list.getLength()/2; i>=0; i--)
            heapAdjust(list, i, list.getLength());

        for (int i=list.getLength()-1; i>=0; i--) {
            //将根结点交换到最后
            Util.swap(list, 0, i);
            //重新调整堆结构，长度减1
            heapAdjust(list, 0, i-1);
        }
    }

    private static void heapAdjust(ListSort list, int i, int length) {
        int temp = list.getData(i);
        //当前结点序号i，其左还是序号为2i，右孩子序号2i+1  调整子树
        for (int j=2*i; j<length-1; j*=2) {
            //找左右孩子中值大的
            if (j<length && list.getData(j) < list.getData(j+1))
                j++;

            //若根结点大于左右孩子，不用调整   大顶堆
            if (list.getData(i) >= list.getData(j)) {
                break;
            } else {
                list.setData(list.getData(j), i);   //将孩子放到双亲结点上
                i = j; //继续向下找
            }

            list.setData(temp, i);  //被调整的值放入最终位置    因为是从下往上逐层调整，所以深度最多为1
        }
    }

    @Test
    public void test() {
        ListSort listSort = new ListSort(20);
        System.out.println(listSort.toString() + listSort.isSorted());
        heapSort(listSort);
        System.out.println(listSort.toString() + listSort.isSorted());
    }
}

