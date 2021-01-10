# 动态规划的算法

动态规划标签
* 穷举（求最值）
    * 列出状态转移方程是重点（最困难的地方）   
* 重叠子问题（备忘录(自顶向下)/db数组(自底向上)优化穷举，消除重叠子问题。例子为斐波那契数列）
    * 备忘录/db数组的优化（状态压缩）
* 最优子结构（通过子问题的最值 可以 得到原问题的最值）


编写状态转移方程前的思考
* 问题的`base case`（最简单情况）是什么？
* 这个问题有什么"状态"？
* 对于每个"状态"，可以做出什么"选择"使得"状态"发生改变？
* 如何定义`dp`数组/函数的含义来表现"状态"和"选择"？
> 解题步骤 
> * 找到状态和选择
> * 明确dp数组/函数的定义
> * 寻找"状态"之间的关系  
``` python
# 初始化 base case
dp[0][0][...] = base case
# 进行状态转移
for 状态1 in 状态1 的所有取值：
    for 状态2 in 状态2 的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1, 选择2, 选择3, ...)
```


> LC --> leetcode上的题

类名|内容
---|---
ZeroOneBag  | 01背包问题
MaxSubArray | `LC简单题`[53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/submissions/)
ClimbStairs | `LC简单题`[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
NthUglyNumber | `LC中等题`[264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/submissions/)
LengthOfLIS | `LC中等题`[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
MaxProfit | `LC中等题`[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/)
CoinChange | `LC中等题`[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
CountNumbersWithUniqueDigits | `LC中等题`[357. 计算各个位数不同的数字个数](https://leetcode-cn.com/problems/count-numbers-with-unique-digits/)
CanPartition | `LC中等题`[416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)
LongestPalindromeSubseq | `LC中等题`[516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/comments/)
ShoppingOffers | `LC中等题`[638. 大礼包](https://leetcode-cn.com/problems/shopping-offers/comments/)
FindLongestChain | `LC中等题`[646. 最长数对链](https://leetcode-cn.com/problems/maximum-length-of-pair-chain/)
CountSubstrings | `LC中等题`[647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/submissions/)
MinSteps | `LC中等题`[650. 只有两个键的键盘](https://leetcode-cn.com/problems/2-keys-keyboard/submissions/)
FindLength | `LC中等题`[718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/comments/)
DeleteAndEarn | `LC中等题`[740. 删除与获得点数](https://leetcode-cn.com/problems/delete-and-earn/)
LenLongestFibSubseq | `LC中等题`[873. 最长的斐波那契子序列的长度](https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/comments/)
StoneGame | `LC中等题`[877. 石子游戏](https://leetcode-cn.com/problems/stone-game/)
SubarrayBitwiseORs | `LC中等题`[898. 子数组按位或操作](https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/)
MinFallingPathSum | `LC中等题`[931. 下降路径最小和](https://leetcode-cn.com/problems/minimum-falling-path-sum/comments/)
MincostTickets | `LC中等题`[983. 最低票价](https://leetcode-cn.com/problems/minimum-cost-for-tickets/submissions/)
DivisorGame | `LC简单题`[1025. 除数博弈](https://leetcode-cn.com/problems/divisor-game/comments/)
LastStoneWeightII | `LC中等题`[1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii/)
