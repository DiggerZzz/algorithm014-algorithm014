//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1  1  1  1  0
//1  1  1  1  0
//1  1  1  1  1
//1  1  1  1  1
//0  0  1  1  1
//
//输出: 4 
// Related Topics 动态规划 
// 👍 555 👎 0


package leetcode.editor.cn;
/**
 * [221]最大正方形
 */
public class MaximalSquare {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row + 1][col + 1];
            int maxSide = 0;
            for(int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    char c = matrix[i - 1][j - 1];
                    int top = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int leftTop = dp[i - 1][j - 1];
                    if(c == '1') {
                        if(top == 0 || left == 0 || leftTop == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(Math.min(top, left), leftTop) + 1;
                        }
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }
}