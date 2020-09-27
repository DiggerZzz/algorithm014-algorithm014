//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1330 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [22]括号生成
 */
public class GenerateParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            helper(0, 0, n, result, "");
            return result;
        }
        private void helper(int left, int right, int count, List<String> result, String s) {
            if(left + right == count * 2) {
                result.add(s);
                return;
            }
            if(left < count) helper(left + 1, right, count, result, s + "(");
            if(right < left) helper(left, right + 1, count, result, s + ")");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }
}