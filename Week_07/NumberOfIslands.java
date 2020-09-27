//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 784 👎 0


package leetcode.editor.cn;
/**
 * [200]岛屿数量
 */
public class NumberOfIslands {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if(grid.length == 0 || grid[0].length == 0)
                return 0;
            int n = grid.length;
            int m = grid[0].length;
            UnionFind unionFind = new UnionFind(grid);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(grid[i][j] == '1') {
                        int parent = i * m + j;
                        if(i > 0 && grid[i - 1][j] == '1')
                            unionFind.union(parent, (i - 1) * m + j);
                        if(i < n - 1 && grid[i + 1][j] == '1')
                            unionFind.union(parent, (i + 1) * m + j);
                        if(j > 0 && grid[i][j - 1] == '1')
                            unionFind.union(parent, i * m + (j - 1));
                        if(j < m - 1 && grid[i][j + 1] == '1')
                            unionFind.union(parent, i * m + (j + 1));
                    }
                }
            }
            return unionFind.count;
        }
        class UnionFind {

            int count;
            int[] parent;

            public UnionFind(char[][] grid) {
                int n = grid.length;
                int m = grid[0].length;
                parent = new int[n * m];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(grid[i][j] == '1') {
                            parent[i * m + j] = i * m + j;
                            count++;
                        }
                    }
                }
            }

            public int find(int x) {
                while(x != parent[x]) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public void union(int x, int z) {
                int rootX = find(x);
                int rootZ = find(z);
                if(rootX == rootZ) return;
                parent[rootX] = rootZ;
                count--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }
}