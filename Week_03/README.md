# Week 3
## 题目
本周做了12题

|题目                |难度                  |
|-------------------|---------------------|
|#105 从前序与中序遍历序列构造二叉树             |中等	                |
|#面试题 17.09 第 k 个数	         |中等	                |
|#15 三数之和	                |中等	                |
|#47 全排列 II                 |中等	                |
|#18 四数之和               |中等	                |
|#657 机器人能否返回原点         |简单	                |
|#46 全排列                |中等	                |
|#236 二叉树的最近公共祖先        |中等	                |
|#77 组合	                |中等                |
|#剑指 Offer 06 从尾到头打印链表        |简单	                |
|#剑指 Offer 05 替换空格        |简单	                |
|#22 括号生成                   |中等	                |

## 知识点
递归、分治、回溯

## 总结
分治和回溯以递归的实现，为递归的特殊使用，其代码实现在递归中的下探步骤后加上分治的结果合并与回溯的结果可行性判断，以下为代码模板

##### 递归
```
public void recursion(params...) {
    //终止
    if(条件) return;

    //处理
    do something;

    //下探
    recursion(params...);

    //重置公共参数
}
```
##### 分治
```
public void partition(params...) {
    //终止
    if(条件) return;

    //处理
    对问题进行拆分

    //下探
    subResult1 = partition(params...);
    subResult2 = partition(params...);
    .
    .
    .

    //合并结果
    merge(subResult1, subResult2, ....)

    //重置公共参数
}
```
##### 回溯
```
public void recall(params...) {
    //终止
    if(条件) return;

    //处理
    do somethine

    //下探
    result = recall(params...);

    //对结果进行可行性分析

    //重置公共参数
}
```