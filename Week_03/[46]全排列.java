//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 856 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        permuteHelp(result, new ArrayList<>(), set, nums);
        return result;
    }

    private void permuteHelp(List<List<Integer>> result, List<Integer> group, Set<Integer> set, int[] nums) {
        if(group.size() == nums.length) {
            result.add(new ArrayList<>(group));
            return;
        }

        for(int num : nums) {
            if(!set.contains(num)) {
                group.add(num);
                set.add(num);
                permuteHelp(result, group, set, nums);
                group.remove(group.size() - 1);
                set.remove(num);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
