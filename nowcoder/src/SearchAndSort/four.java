package SearchAndSort;

/**
 * 这题写的不好,可以重做!
 */

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/6 9:21
 * @description 在数组中的两个数字，
 * 如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
 **/
public class four {

    public int InversePairs(int[] array) {
        /**
         * 暴力求解:显然可以通过,但是时间复杂度较大,过不了关
         */
        int kmod = 1000000007;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    res += 1;
                    res %= kmod;
                }
            }
        }
        return res;
    }

    /**
     * 第二种方法,归并排序
     * 思路:1.首先将数组无限两两分割
     * 2.合并的时候,比较两边数组的末尾数字的大小,判断逆序对的个数
     */
    //6 8 9  2 4 5 7
    //
    public int InversePairs1(int[] array) {
        return merge(array, 0, array.length - 1);
    }

    public int merge(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        int count = 0;
        count += merge(nums, start, mid);
        count += merge(nums, mid + 1, end);
        int[] work = new int[end - start + 1];
        int i = start, j = mid + 1;
        int p=0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                work[p++] = nums[i++];
            }
            if (nums[i] > nums[j]) {
                count +=(mid - i + 1)%1000000007;
                work[p++] = nums[j++];
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                work[p++] = nums[i++];
            }
        }
        if (j <= end) {
            while (j <= end) {
                work[p++] = nums[j++];
            }
        }
        for (int k = 0; k < work.length; k++) {
            nums[start + k] = work[k];
        }
        return count ;

    }
}
