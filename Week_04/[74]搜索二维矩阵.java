//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 232 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int col = matrix.length, row = matrix[0].length;
        int start = 0, end = col * row - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            int guessNum = matrix[mid / row][mid % row];
            if(target < guessNum) {
                end = mid - 1;
            } else if(target > guessNum) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean searchInCol(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        while(top <= bottom) {
            int mid = (top + bottom) / 2;
            if(target < matrix[mid][0]) {
                bottom = mid - 1;
            } else if(target > matrix[mid][matrix[mid].length - 1]) {
                top = mid + 1;
            } else {
                return searchInRow(matrix[mid], target);
            }
        }
        return false;
    }

    private boolean searchInRow(int[] row, int target) {
        System.out.println(Arrays.toString(row));
        int left = 0, right = row.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target < row[mid]) {
                right = mid - 1;
            } else if(target > row[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
