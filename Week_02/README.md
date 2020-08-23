# Week 2
## 题目
本周做了16题

|题目                |难度                  |
|-------------------|---------------------|
|#264 丑数 II             |中等	                |
|#347 前 K 个高频元素	         |中等	                |
|#429 N叉树的层序遍历	         |中等	                |
|#283 移动零	            |简单	                |
|#145 二叉树的后序遍历         |困难	                |
|#144 二叉树的前序遍历	         |中等	                |
|#94 二叉树的中序遍历         |中等	                |
|#49 字母异位词分组         |中等	                |
|#104 二叉树的最大深度	       |简单	                |
|#258 各位相加         |简单	                |
|#412 Fizz Buzz        |简单	                |
|#239 滑动窗口最大值        |困难	                |
|#589 N叉树的前序遍历        |简单	                |
|#242 有效的字母异位词        |简单	                |
|#1021 删除最外层的括号         |简单	                |
|#350 两个数组的交集 II        |简单	                |

##知识点
哈希表、树、二叉树、二叉搜索树、堆、二叉堆、图

##总结
树的前、中、后序遍历

public List<Integer> traversal(TreeNode root) {
     if (root == null) return new ArrayList<Integer>();
     
     TreeNode node = root;
     List<Integer> ret = new ArrayList<Integer>();
     
     Stack<TreeNode> stack = new Stack<TreeNode>();
     while(node != null || !stack.isEmpty()) {
         while (node != null) {
             stack.push(node);
             // 先序遍历
             node = node.left;
         }
         node = stack.pop();
         // 中序遍历
         node = node.right;
         // 后序遍历
     }
     return ret;
 }