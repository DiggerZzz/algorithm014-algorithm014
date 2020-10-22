//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 280 👎 0


package leetcode.editor.cn;
/**
 * [387]字符串中的第一个唯一字符
 */
public class FirstUniqueCharacterInAString {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int firstUniqChar(String s) {
            if(s.length() == 0)
                return -1;
            int[] map = new int[26];
            for(char c : s.toCharArray())
                map[c - 'a'] += 1;
            for(int i = 0; i < s.length(); i++) {
                if(map[s.charAt(i) - 'a'] == 1)
                    return i;
            }
            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }
}