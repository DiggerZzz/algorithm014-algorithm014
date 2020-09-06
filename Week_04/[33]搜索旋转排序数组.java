//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 929 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int len = nums.length;
        int start = findStart(nums, 0, len - 1);
        int end = start == 0 ? len - 1 : start - 1 + len;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(target < nums[mid % len])
                end = mid - 1;
            else if(target > nums[mid % len])
                start = mid + 1;
            else
                return mid % len;
        }
        return -1;
    }

    public int findStart(int[] nums, int left, int right) {
        if(left == right)
            return left;

        int mid = (left + right) / 2;
        if(nums[mid] > nums[right])
            return findStart(nums, mid + 1, right);
        else
            return findStart(nums, left, mid);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
