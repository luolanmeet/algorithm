# 回溯算法  

解决一个回溯问题，实际上就是一个决策树的遍历过程，需要考虑3个问题
* 路径：已经做出的选择
* 选择列表：当前可以做的选择
* 结束条件：到达决策树底层，无法在做出选择的条件
```python
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
核心就是for循环里的递归，递归调用前做选择，递归调用后撤销选择。
就是一棵多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做选择和撤销选择的操作。

> 回溯 = 深度优先遍历 + 状态重置 + 剪枝
> 有没有解、求所有解、求最优解
> 隐式的图的深度优先搜索算法DFS

> LC --> leetcode上的题

类名|内容
---|---
IsMatch | `LC困难题`[10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)
LetterCombinations | `LC中等题`[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
SolveSudoku | `LC困难题`[37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/)
CombinationSum | `LC中等题`[39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)
CombinationSum2 | `LC中等题`[40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)
Permute | `LC中等题`[46. 全排列](https://leetcode-cn.com/problems/permutations/)
PermuteUnique | `LC中等题`[47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)
SolveNQueens | `LC困难题`[51. N皇后](https://leetcode-cn.com/problems/n-queens/)
TotalNQueens | `LC困难题`[52. N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/)
GetPermutation | `LC中等题`[60. 第k个排列](https://leetcode-cn.com/problems/permutation-sequence/)
Combine | `LC中等题`[77. 组合](https://leetcode-cn.com/problems/combinations/)
Subsets | `LC中等题`[78. 子集](https://leetcode-cn.com/problems/subsets/)
Exist | `LC中等题`[79. 单词搜索](https://leetcode-cn.com/problems/word-search/)
SubsetsWithDup | `LC中等题`[90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)
Partition | `LC中等题`[131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)
IsAdditiveNumber | `LC中等题`[306. 累加数](https://leetcode-cn.com/problems/additive-number/)
CountArrangement | `LC中等题`[526. 优美的排列](https://leetcode-cn.com/problems/beautiful-arrangement/)
CanPartitionKSubsets | `LC中等题`[698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/comments/)
SplitIntoFibonacci | `LC中等题`[842. 将数组拆分成斐波那契序列](https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/)
NumTilePossibilities | `LC中等题`[1079. 活字印刷](https://leetcode-cn.com/problems/letter-tile-possibilities/)
