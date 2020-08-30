//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 334 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelp(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public void combineHelp(List<List<Integer>> result, List<Integer> group, int start, int n, int k) {
        if(k == 0) {
            result.add(new ArrayList<>(group));
            return;
        }

        for(int i = start; i <= n; i++) {
            group.add(i);
            combineHelp(result, group, i + 1, n, k - 1);
            group.remove(group.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
