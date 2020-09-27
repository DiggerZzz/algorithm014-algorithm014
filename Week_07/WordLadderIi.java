//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 330 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * [126]单词接龙 II
 */
public class WordLadderIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> result = new ArrayList<>();
            Set<String> dic = new HashSet<>(wordList);
            if(dic.size() == 0 || !dic.contains(endWord))
                return result;
            Map<String, Set<String>> successors = new HashMap<>();
            boolean found = bfs(beginWord, endWord, dic, successors);
            if(!found)
                return result;

            Deque<String> path = new ArrayDeque<>();
            path.add(beginWord);
            dfs(beginWord, endWord, successors, path, result);
            return result;
        }

        private void dfs(String beginWord, String endWord, Map<String, Set<String>> successors, Deque<String> path, List<List<String>> result) {
            if(beginWord.equals(endWord)) {
                result.add(new ArrayList<>(path));
                return;
            }
            if(!successors.containsKey(beginWord))
                return;
            Set<String> successorWords = successors.get(beginWord);
            for(String word : successorWords) {
                path.addLast(word);
                dfs(word, endWord, successors, path, result);
                path.removeLast();
            }
        }

        private boolean bfs(String beginWord, String endWord, Set<String> dic, Map<String, Set<String>> successor) {
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            visited.add(endWord);

            Set<String> beginVisited = new HashSet<>();
            beginVisited.add(beginWord);
            Set<String> endVisited = new HashSet<>();
            endVisited.add(endWord);

            boolean forward = true;
            boolean found = false;
            while(!beginVisited.isEmpty() && !endVisited.isEmpty()) {
                if(beginVisited.size() > endVisited.size()) {
                    Set<String> temp = beginVisited;
                    beginVisited = endVisited;
                    endVisited = temp;

                    forward = !forward;
                }
                Set<String> nextVisited = new HashSet<>();
                for(String curWord : beginVisited) {
                    char[] charArr = curWord.toCharArray();
                    for(int i = 0; i < curWord.length(); i++) {
                        char chr = charArr[i];
                        for(char c = 'a'; c <= 'z'; c++) {
                            if(chr == c) continue;

                            charArr[i] = c;
                            String newWord = String.valueOf(charArr);
                            if(dic.contains(newWord)) {
                                if(endVisited.contains(newWord)) {
                                    found = true;
                                    addToSuccessors(successor, forward, curWord, newWord);
                                }
                                if(!visited.contains(newWord)) {
                                    nextVisited.add(newWord);
                                    addToSuccessors(successor, forward, curWord, newWord);
                                }
                            }
                        }
                        charArr[i] = chr;
                    }
                }
                beginVisited = nextVisited;
                visited.addAll(nextVisited);
                if(found)
                    break;
            }
            return found;
        }

        private void addToSuccessors(Map<String, Set<String>> successors, boolean forward,
                                     String currentWord, String nextWord) {
            if (!forward) {
                String temp = currentWord;
                currentWord = nextWord;
                nextWord = temp;
            }

            // Java 1.8 以后支持
            successors.computeIfAbsent(currentWord, a -> new HashSet<>());
            successors.get(currentWord).add(nextWord);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
    }
}