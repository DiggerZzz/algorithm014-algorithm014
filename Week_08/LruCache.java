//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 921 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [146]LRU缓存机制
 */
public class LruCache {
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkNode> map = new HashMap<>();
    private int size = 0;
    private int max = 0;
    private DLinkNode head, tail;

    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int get(int key) {
        DLinkNode node = map.get(key);
        if(node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DLinkNode node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        if(size == max) {
            DLinkNode temp = tail;
            removeNode(temp);
            map.remove(temp.key);
        }
        DLinkNode node = new DLinkNode(key, value);
        addNode(node);
        map.put(key, node);
    }

    private void addNode(DLinkNode node) {
        DLinkNode h = head;
        head = node;
        node.next = h;

        if(h == null) {
            tail = node;
        } else {
            h.pre = node;
        }
        size++;
    }

    private void removeNode(DLinkNode node) {
        DLinkNode pre = node.pre;
        DLinkNode next = node.next;

        if(pre == null) {
            head = next;
        } else {
            pre.next = next;
            node.pre = null;
        }

        if(next == null) {
            tail = pre;
        } else {
            next.pre = pre;
            node.next = null;
        }
        size--;
    }

    private void moveToHead(DLinkNode node) {
        if(head == node)
            return;
        removeNode(node);
        addNode(node);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(2);
        solution.put(1, 1);
        solution.put(2, 2);
        System.out.println(solution.get(1));
        solution.put(3, 3);
        System.out.println(solution.get(2));
        solution.put(4, 4);
        System.out.println(solution.get(1));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));
    }
}