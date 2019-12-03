package sort;

/**
 * 计数排序  线性时间复杂度，非比较类排序的一种
 * <p>
 * 1. 创建长度等于取值范围的数组
 * 2. 遍历待排数组，将读到的整数值相对应的数组下标加一
 * 3. 遍历结束后，该数组中每一个下标位置的值代表数列中对应整数出现的次数
 * <p>
 * 适用于一定范围内的整数排序，但数列最大和最小差值过大时也不适用
 * <p>
 * 原始数组长度n，最大最小整数差值为m
 * 时间复杂度：O(n+m) 有遍历原始数组，输出统计数组的运算量为m
 * 空间复杂度: O(m) 统计数组大小
 * 稳定性：优化后稳定
 */
@SuppressWarnings("Duplicates")
public class CountSort {

    public static int[] countSort1(int[] array) {
        // 获取数组的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 根据数列最大值确定统计数组长度
        int[] countArray = new int[max + 1];

        // 遍历数列，填充统计数组
        for (int i : array) {
            countArray[i]++;
        }

        // 统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    /**
     * 数组的最小值比较大情况
     * 例如 [90,94,92,100,99]
     */
    public static int[] countSort2(int[] array) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        // 计算差值
        int d = max - min;
        int[] countArray = new int[d + 1];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        int[] sortedArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i + min;
            }
        }
        return sortedArray;
    }


    /**
     * 现实场景的优化
     * 例如 成绩表 {A:90, B:99, C:95, D:94, E:95}
     * 排序后有两个95的元素，不知哪个在前
     * 目的：保持排序算法的稳定性
     */
    public static int[] countSort3(int[] array) {
        int min = array[0], max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int d = max - min;
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        // 对统计数组做变形，从第二个元素开始，每个元素都加上前面所有元素之和
        // 目的：让统计数组中存储的元素值，等于相应整数(下标)的最终排序位置的序号
        // 统计数组的下标是输出数组的元素值，统计数组的元素内容代表个数
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 倒序遍历原始数组，从统计数组中找到正确位置 (现在统计数组的元素值代表排序后元素的位置)
        int[] sortedArray = new int[array.length];
        for (int i = countArray.length - 1; i >= 0; i--) {
            // 计算出原始数组中元素应该在统计数组的哪个位置
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            // 指示如果下次遍历到相同元素时，该元素应在的下标位置
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }
}
