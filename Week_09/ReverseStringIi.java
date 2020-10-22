//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 100 👎 0


package leetcode.editor.cn;
/**
 * [541]反转字符串 II
 */
public class ReverseStringIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            if(s.length() == 0)
                return s;
            char[] charArray = s.toCharArray();
            int start = 0;
            while(start < s.length()) {
                int end = Math.min(start + 2 * k, s.length());
                reverse(charArray, start, end - start >= k ? start + k - 1 : end - 1);
                start = end;
            }
            return String.valueOf(charArray);
        }

        private void reverse(char[] charArray, int start, int end) {
            while(start < end) {
                swap(charArray, start++, end--);
            }
        }

        private void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
    }
}