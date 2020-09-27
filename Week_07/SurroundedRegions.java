//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 382 👎 0


package leetcode.editor.cn;
/**
 * [130]被围绕的区域
 */
public class SurroundedRegions {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public void solve(char[][] board) {
            if(board.length <= 2 || board[0].length <= 2)
                return;
            int n = board.length;
            int m = board[0].length;
            for(int i = 0; i < n; i++) {
                if(board[i][0] == 'O')
                    dfs(board, i, 0);
                if(board[i][m - 1] == 'O')
                    dfs(board, i, m - 1);
            }
            for(int j = 0; j < m; j++) {
                if(board[0][j] == 'O')
                    dfs(board, 0, j);
                if(board[n - 1][j] == 'O')
                    dfs(board, n - 1, j);
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == '#')
                        board[i][j] = 'O';
                    else if(board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
                return;
            board[i][j] = '#';
            for(int[] d : dir) {
                dfs(board, i + d[0], j + d[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }
}