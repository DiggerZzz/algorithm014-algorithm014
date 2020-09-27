//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 450 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [127]单词接龙
 */
public class WordLadder {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1.将wordList转成hash表，以便快速查找
        Set<String> dir = new HashSet<>(wordList);
        if(dir.size() == 0 || !dir.contains(endWord))
            return 0;

        //2.访问记录hash表
        Set<String> visit = new HashSet<>();
        //向左和向右的hash表，代替单向队列
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        //3.双向bfs
        int count = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            //选择路劲较小的进行扩散
            if(beginSet.size() > endSet.size()) {
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }

            //创建下一步的扩散hash表，扩散后成为新的beginSet
            Set<String> nextSet = new HashSet<>();
            for(String word : beginSet) {
                char[] wordCharArr = word.toCharArray();
                //对单词的每一位进行26个字母替换查找
                for(int i = 0; i < wordCharArr.length; i++) {
                    char chr = wordCharArr[i];
                    for(char j = 'a'; j <= 'z'; j++) {
                        if(j == chr) continue;

                        wordCharArr[i] = j;
                        String newWord = String.valueOf(wordCharArr);
                        if(dir.contains(newWord)) {
                            if(endSet.contains(newWord)) {
                                return ++count;
                            }
                            if(!visit.contains(newWord)) {
                                visit.add(newWord);
                                nextSet.add(newWord);
                            }
                        }
                    }
                    wordCharArr[i] = chr;
                }
            }
            //废弃旧的beginSet，使用nextSet代替
            beginSet = nextSet;
            count++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
    }
}