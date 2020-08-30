// 根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
// 你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树： 
//
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 648 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildHelper(map, preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildHelper(Map<Integer, Integer> map, int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if(pLeft == pRight)
            return null;
        int rootVal = preorder[pLeft];
        TreeNode root = new TreeNode(rootVal);
        //寻找中序中的根节点下标
        int iRootIndex = map.get(rootVal);
        /*for(int i = iLeft; i < iRight; i++) {
            if(rootVal == inorder[i]) {
                iRootIndex = i;
                break;
            }
        }*/
        //左子树节点数量
        int leftCount = iRootIndex - iLeft;
        //构造左子树
        root.left = buildHelper(map, preorder, pLeft + 1, pLeft + leftCount + 1, inorder, iLeft, iRootIndex);
        //构造右子树
        root.right = buildHelper(map, preorder, pLeft + leftCount + 1, pRight, inorder, iRootIndex + 1, iRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
