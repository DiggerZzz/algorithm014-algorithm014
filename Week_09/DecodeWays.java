//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可以包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 537 👎 0


package leetcode.editor.cn;
/**
 * [91]解码方法
 */
public class DecodeWays {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++) {
            char pre = s.charAt(i - 2);
            char cur = s.charAt(i - 1);

            if(cur == '0') {
                if(pre == '1' || pre == '2')
                    dp[i] = dp[i - 2];
                else
                    return 0;
            } else if(pre == '1' || (pre == '2' && cur >= '0' && cur <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
    }
}