//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 441 👎 0


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0)
            return nums;

        //计数log(n)
        Map<Integer, Integer> hash = new HashMap<>();
        for(Integer num : nums)
            hash.put(num, hash.getOrDefault(num, 0) + 1);

        //按优先级排列log(nlogn)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        if(o1.getValue() > o2.getValue())
                            return -1;
                        else if(o1.getValue() < o2.getValue())
                            return 1;
                        else
                            return 0;
                    }
                }
        );
        for(Map.Entry<Integer, Integer> entry : hash.entrySet())
            pq.add(entry);

        //取出结果log(k)
        int[] result = new int[k];
        for(int i = 0; i < k; i++)
            result[i] = pq.poll().getKey();

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
