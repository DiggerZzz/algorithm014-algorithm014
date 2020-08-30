//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 383 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelp(result, new ArrayList<>(), used, 0, nums);
        return result;
    }

    private void permuteHelp(List<List<Integer>> result, List<Integer> group, boolean[] used, int level, int[] nums) {
        if(level == nums.length) {
            result.add(new ArrayList<>(group));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[level] = true;
                group.add(nums[i]);
                permuteHelp(result, group, used, level + 1, nums);
                group.remove(group.size() - 1);
                used[level] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
