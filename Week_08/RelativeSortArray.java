//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 81 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [1122]数组的相对排序
 */
public class RelativeSortArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, Integer> comparator = new HashMap<>();

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            if(arr1.length == 0 || arr2.length == 0)
                return arr1;
            for(int i = 0; i < arr2.length; i++) {
                comparator.put(arr2[i], i);
            }
            mergeSort(arr1, 0, arr1.length - 1);
            return arr1;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if(start == end)
                return;
            int mid = (start + end) >> 1;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }

        private void merge(int[] nums, int start, int mid, int end) {
            int[] temp = new int[end - start + 1];
            int pt = 0, p1 = start, p2 = mid + 1;
            while(p1 <= mid && p2 <= end) {
                if(comparator.get(nums[p1]) == null && comparator.get(nums[p2]) == null) {
                    if(nums[p1] <= nums[p2]) {
                        temp[pt++] = nums[p1++];
                    } else {
                        temp[pt++] = nums[p2++];
                    }
                } else if(comparator.get(nums[p1]) == null) {
                    temp[pt++] = nums[p2++];
                } else if(comparator.get(nums[p2]) == null) {
                    temp[pt++] = nums[p1++];
                } else {
                    if(comparator.get(nums[p1]) - comparator.get(nums[p2]) <= 0) {
                        temp[pt++] = nums[p1++];
                    } else {
                        temp[pt++] = nums[p2++];
                    }
                }
            }

            while(p1 <= mid) temp[pt++] = nums[p1++];
            while(p2 <= end) temp[pt++] = nums[p2++];

            for(int i = 0; i < temp.length; i++) {
                nums[i + start] = temp[i];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //[26,21,11,20,50,34,1,18]
    
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        solution.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }
}