//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 63 👎 0


package leetcode.editor.cn;
/**
 * [917]仅仅反转字母
 */
public class ReverseOnlyLetters {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseOnlyLetters(String s) {
            if(s.length()  <= 1)
                return s;
            char[] dummy = s.toCharArray();
            for(int i = 0, j = dummy.length - 1; i < j; i++, j--) {
                while(i < j && !isLetter(dummy[i])) i++;
                while(i < j && !isLetter(dummy[j])) j--;
                char temp = dummy[i];
                dummy[i] = dummy[j];
                dummy[j] = temp;

            }
            return String.valueOf(dummy);
        }

        private boolean isLetter(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
    }
}