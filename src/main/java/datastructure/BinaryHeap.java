package datastructure;

import java.util.Arrays;

/**
 * 二叉堆实现
 * 因为二叉堆是完全二叉树，所以底层适合数组存储
 */
public class BinaryHeap {

    private int[] heap;
    private HeapType type;

    private BinaryHeap(int[] heap) {
        this.heap = heap;
        type = getHeapType(heap);
    }

    // 结点序号从0开始
    public static BinaryHeap buildMaxHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length, HeapType.MaxHeap);
        }
        return new BinaryHeap(array);
    }

    public static BinaryHeap buildMinHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length, HeapType.MinHeap);
        }
        return new BinaryHeap(array);
    }

    public static HeapType getHeapType(int[] heap) {
        int parentIndex = 0;
        int childIndex = 2 * parentIndex + 1;
        HeapType type;

        if (heap[parentIndex] < heap[childIndex]) {
            type = HeapType.MinHeap;
        } else {
            type = HeapType.MaxHeap;
        }

        while (childIndex < heap.length) {
            // 找最值
            if (childIndex + 1 < heap.length
                    && (type == HeapType.MaxHeap ? heap[childIndex + 1] > heap[childIndex] : heap[childIndex + 1] < heap[childIndex])) {
                childIndex++;
            }

            if ((type == HeapType.MaxHeap && heap[parentIndex] < heap[childIndex])
                || (type == HeapType.MinHeap && heap[parentIndex] > heap[childIndex])) {
                return HeapType.NoHeap;
            }
            childIndex = 2 * ++parentIndex + 1;
        }
        return type;
    }

    public void insert(int data) {
        int[] newHeap = new int[heap.length + 1];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        newHeap[newHeap.length - 1] = data;
        heap = newHeap;
        upAdjust(heap);
    }

    public int pop() {
        int pop = heap[0];
        heap[0] = heap[heap.length - 1];

        int[] newHeap = new int[heap.length - 1];
        System.arraycopy(heap, 0, newHeap, 0, newHeap.length);
        heap = newHeap;

        for (int i = (heap.length - 2) / 2; i >= 0; i--) {
            downAdjust(heap, i, heap.length, type);
        }
        return pop;
    }

    public boolean hasNext() {
        return heap.length > 0;
    }

    /**
     * 上浮调整
     * 用于大顶堆插入结点时
     */
    private void upAdjust(int[] arr) {
        int child = arr.length - 1;
        int parent = (child - 1) / 2;
        // 保存上浮结点的值，用于最后赋值
        int temp = arr[child];
        while (child > 0
                && (type == HeapType.MaxHeap ? temp > arr[parent] : temp <= arr[parent])) {
            // 无真正交换，单向赋值，只是将父节点下调
            arr[child] = arr[parent];
            // 尝试继续上浮
            child = parent;
            parent = (child - 1) / 2;
        }
        // 最后将保存的值赋值给上浮的位置
        arr[child] = temp;
    }

    /**
     * 小顶堆
     * i 下沉结点
     */
    private static void downAdjust(int[] arr, int i, int length, HeapType type) {
        int temp = arr[i];
        int child = 2 * i + 1;
        while (child < length) {
            // 如果有右孩子，找到子结点的最小/大值
            if (child + 1 < length
                    && (type == HeapType.MaxHeap ? arr[child + 1] > arr[child] : arr[child + 1] < arr[child])) {
                // 定位到右孩子
                child++;
            }

            // 如果父节点满足堆的条件则退出
            if (type == HeapType.MaxHeap ? temp > arr[child] : temp < arr[child]) {
                break;
            }

            arr[i] = arr[child];
            i = child;
            child = 2 * child + 1;
        }
        arr[i] = temp;
    }

    public enum HeapType {
        MaxHeap,
        MinHeap,
        NoHeap
    }

    public String toString() {
        return (type + Arrays.toString(heap));
    }

    public HeapType getType() {
        return type;
    }

    public int[] getHeap() {
        return heap;
    }
}