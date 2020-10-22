//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 248 👎 0


package leetcode.editor.cn;
/**
 * [557]反转字符串中的单词 III
 */
public class ReverseWordsInAStringIii {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseWords(String s) {
            if(s.length() <= 1)
                return s;
            String[] arr = s.split(" ");
            StringBuilder builder = new StringBuilder();
            for(String str : arr) {
                builder.append(reverse(str)).append(' ');
            }
            return builder.toString().trim();
        }

        private String reverse(String s) {
            char[] arr = s.toCharArray();
            for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return String.valueOf(arr);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }
}