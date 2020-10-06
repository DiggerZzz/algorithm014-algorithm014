//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 633 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [56]合并区间
 */
public class MergeIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0)
                return intervals;
            sort(intervals, 0, intervals.length - 1);
            List<int[]> merge = new ArrayList<>();
            for(int[] interval : intervals) {
                int l = interval[0];
                int r = interval[1];

                if(merge.size() == 0 || merge.get(merge.size() - 1)[1] < l) {
                    merge.add(new int[]{l, r});
                } else {
                    int maxR = Math.max(merge.get(merge.size() - 1)[1], r);
                    merge.get(merge.size() - 1)[1] = maxR;
                }
            }

            return merge.toArray(new int[merge.size()][]);
        }

        private void sort(int[][] intervals, int start, int end) {
            if(start >= end)
                return;
            int pivotIndex = partition(intervals, start, end);
            sort(intervals, start, pivotIndex - 1);
            sort(intervals, pivotIndex + 1, end);
        }

        private int partition(int[][] intervals, int start, int end) {
            int[] pivot = intervals[start];
            while(start < end) {
                while(start < end && intervals[end][0] >= pivot[0])
                    end--;
                intervals[start] = intervals[end];

                while(start < end && intervals[start][0] <= pivot[0])
                    start++;
                intervals[end] = intervals[start];
            }
            intervals[start] = pivot;
            return start;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }
}