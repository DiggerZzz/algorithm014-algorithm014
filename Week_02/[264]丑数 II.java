//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 366 👎 0


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = result[a] * 2, n3 = result[b] * 3, n5 = result[c] * 5;
            result[i] = Math.min(Math.min(n2, n3), n5);
            if(result[i] == n2) a++;
            if(result[i] == n3) b++;
            if(result[i] == n5) c++;
        }
        return result[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
