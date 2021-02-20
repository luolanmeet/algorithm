# 动态规划的算法

动态规划标签
* 穷举（求最值）
    * 列出状态转移方程是重点（最困难的地方）   
* 重叠子问题（备忘录(自顶向下)/db数组(自底向上)优化穷举，消除重叠子问题。例子为斐波那契数列）
    * 备忘录/db数组的优化（状态压缩）
* 最优子结构（通过子问题的最值 可以 得到原问题的最值）
> dp正常都是 O(mn)的复杂度，因为都是两层for循环

编写状态转移方程前的思考
* 问题的`base case`（最简单情况）是什么？
* 这个问题有什么"状态"？
    * 判断状态的识别是否正确，可以用“选出的这些状态，能否组成一个个子问题？”来判断
* 对于每个"状态"，可以做出什么"选择"使得"状态"发生改变？
* 如何定义`dp`数组/函数的含义来表现"状态"和"选择"？
    * dp数组的索引要能反映出状态（多个状态就是多个维度），而值一般是子问题的解
> 解题步骤 
> * 找到状态和选择
> * 明确dp数组/函数的定义
> * 寻找"状态"之间的关系  

> 明确dp数组所存数据的含义。根据dp数组的定义，运用数学归纳法的思想<br>
> 假设dp[0..i-1]都已知，想办法求出dp[i]。如果没法完成这一步，可能是dp数组定义不恰当<br>
> 或存储的信息还不够，需要把dp数组扩大成二维数组甚至三维数组

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
IsMatch | `LC困难题`[10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)
MaxSubArray | `LC简单题`[53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/submissions/)
ClimbStairs | `LC简单题`[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
MinDistance | `LC困难题`[72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)
NthUglyNumber | `LC中等题`[264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/submissions/)
LengthOfLIS | `LC中等题`[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
MaxProfit | `LC中等题`[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/)
CoinChange | `LC中等题`[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
MaxEnvelopes | `LC困难题`[354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/) 
CountNumbersWithUniqueDigits | `LC中等题`[357. 计算各个位数不同的数字个数](https://leetcode-cn.com/problems/count-numbers-with-unique-digits/)
CanPartition | `LC中等题`[416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)
LongestPalindromeSubseq | `LC中等题`[516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/comments/)
Change | `LC中等题`[518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)
ShoppingOffers | `LC中等题`[638. 大礼包](https://leetcode-cn.com/problems/shopping-offers/comments/)
FindLongestChain | `LC中等题`[646. 最长数对链](https://leetcode-cn.com/problems/maximum-length-of-pair-chain/)
CountSubstrings | `LC中等题`[647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/submissions/)
MinSteps | `LC中等题`[650. 只有两个键的键盘](https://leetcode-cn.com/problems/2-keys-keyboard/submissions/)
FindLength | `LC中等题`[718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/comments/)
DeleteAndEarn | `LC中等题`[740. 删除与获得点数](https://leetcode-cn.com/problems/delete-and-earn/)
LenLongestFibSubseq | `LC中等题`[873. 最长的斐波那契子序列的长度](https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/comments/)
StoneGame | `LC中等题`[877. 石子游戏](https://leetcode-cn.com/problems/stone-game/)
SuperEggDrop | `LC困难题`[887. 鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/)
SubarrayBitwiseORs | `LC中等题`[898. 子数组按位或操作](https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/)
MinFallingPathSum | `LC中等题`[931. 下降路径最小和](https://leetcode-cn.com/problems/minimum-falling-path-sum/comments/)
MincostTickets | `LC中等题`[983. 最低票价](https://leetcode-cn.com/problems/minimum-cost-for-tickets/submissions/)
DivisorGame | `LC简单题`[1025. 除数博弈](https://leetcode-cn.com/problems/divisor-game/comments/)
LastStoneWeightII | `LC中等题`[1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii/)
LongestCommonSubsequence | `LC中等题`[1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
MinInsertions | `LC困难题`[1312. 让字符串成为回文串的最少插入次数](https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
