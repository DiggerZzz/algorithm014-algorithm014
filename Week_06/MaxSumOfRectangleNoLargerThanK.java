//给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。 
//
// 示例: 
//
// 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
//输出: 2 
//解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 说明： 
//
// 
// 矩阵内的矩形区域面积必须大于 0。 
// 如果行数远大于列数，你将如何解答呢？ 
// 
// Related Topics 队列 二分查找 动态规划 
// 👍 122 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * [363]矩形区域不超过 K 的最大数值和
 */
public class MaxSumOfRectangleNoLargerThanK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            if(matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int n = matrix.length;
            int m = matrix[0].length;
            int result = Integer.MIN_VALUE;
            for(int l = 0; l < m; l++) {
                int[] rowSum = new int[n];
                for(int r = l; r < m; r++) {
                    for(int i = 0; i < rowSum.length; i++) {
                        rowSum[i] += matrix[i][r];
                    }
                    result = Math.max(result, getMax(rowSum, k));
                }
            }
            return result;
        }

        private int getMax(int[] rowSum, int k) {
            int sum = rowSum[0], max = sum;
            for (int i = 1; i < rowSum.length; i++) {
                if(sum > 0) sum += rowSum[i];
                else sum = rowSum[i];

                if (sum > max)
                    max = sum;
            }
            if(max <= k) {
                return max;
            }

            max = Integer.MIN_VALUE;
            for(int i = 0; i < rowSum.length; i++) {
                sum = 0;
                for(int j = i; j < rowSum.length; j++) {
                    sum += rowSum[j];
                    if(sum <= k && sum > max)
                        max = sum;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
    }
}