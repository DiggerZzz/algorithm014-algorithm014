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
// 👍 426 👎 0


import javafx.util.Pair;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0)
            return 0;
        Map<String, List<String>> dir = new HashMap<>();
        for(String word : wordList) {
            for(int i = 0; i < word.length(); i++) {
                char[] strData = word.toCharArray();
                strData[i] = '*';
                String key = String.valueOf(strData);
                List<String> group = dir.getOrDefault(key, new ArrayList<>());
                group.add(word);
                dir.put(key, group);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        while(!queue.isEmpty())  {
            System.out.println(queue);
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int step = pair.getValue();
            for(int i = 0; i < word.length(); i++) {
                char[] strData = word.toCharArray();
                strData[i] = '*';
                String key = String.valueOf(strData);
                for(String matchWord : dir.getOrDefault(key, new ArrayList<>())) {
                    if(matchWord.equals(endWord))
                        return step + 1;

                    if(visit.contains(matchWord))
                        continue;
                    else {
                        visit.add(matchWord);
                        queue.add(new Pair<>(matchWord, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
