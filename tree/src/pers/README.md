# 树的算法

### 树的一些公式
#### 叶子节点数
满k叉树节点数 = (k^树高度 - 1) / (k - 1)

> 回溯算法的时间复杂度通常就是树的节点数，(通常这棵树是满二叉树)
>
> 数的高度就是题目的选项的个数，即用于做 选择/撤销选择 的选项的个数
> 
> 即 ： O(n) = 2^n
> 
> > 满k叉树，注意不要和全排列弄混了，全排列是一棵决策树，不是满k叉树

> LC --> leetcode上的题

类名|内容
---|---
BinaryTreeTraversal |  前序、中序、后序、层次遍历
BinaryTreeDepth     |  求二叉树深度
BinaryTreeCopy      |  克隆二叉树
RecoverTree         | `LC中等题`[99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)
IsSymmetric         | `LC简单题`[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
BuildTree1          | `LC中等题`[105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
BuildTree2          | `LC中等题`[106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
PathSum             | `LC中等题`[113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)
Flatten             | `LC中等题`[114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)
ConnectBro          | `LC中等题`[116. 填充同一层的兄弟节点](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)
MaxPathSum          | `LC困难题`[124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
SumNumbers          | `LC中等题`[129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)
RightSideView       | `LC中等题`[199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
CountNodes          | `LC中等题`[222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/)
KthSmallest         | `LC中等题`[230. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/submissions/)
CommonAncestor      | `LC中等题`[236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
IsValidSerialization| `LC中等题`[331. 验证二叉树的前序序列化](https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/)
Rob3| `LC中等题`[337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)
FrequentTreeSum     | `LC中等题`[508. 出现次数最多的子树元素和](https://leetcode-cn.com/problems/most-frequent-subtree-sum/)
BottomLeftValue     | `LC中等题`[513. 找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)
LargestValues       | `LC中等题`[515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
Tree2str            | `LC简单题`[606. 根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)
AddOneRow           | `LC中等题`[623. 在二叉树中增加一行](https://leetcode-cn.com/problems/add-one-row-to-tree/)
MaximumBinaryTree   | `LC中等题`[654. 最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree/)
WidthOfBinaryTree   | `LC中等题`[662. 二叉树最大宽度](https://leetcode-cn.com/problems/maximum-width-of-binary-tree/)
InsertIntoBST       | `LC中等题`[701. 二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
PruneTree           | `LC中等题`[814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning/)
DistanceK           | `LC中等题`[863. 二叉树中所有距离为 K 的结点](https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/)
AllPossibleFBT      | `LC中等题`[894. 所有可能的满二叉树](https://leetcode-cn.com/problems/all-possible-full-binary-trees/)
RangeSumBST         | `LC简单题`[938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst/)
FlipEquiv           | `LC中等题`[951. 翻转等价二叉树](https://leetcode-cn.com/problems/flip-equivalent-binary-trees/)
CompleteTree        | `LC中等题`[958. 二叉树的完全性检验](https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/)
UnivalTree          | `LC简单题`[965. 单值二叉树](https://leetcode-cn.com/problems/univalued-binary-tree/)
DistributeCoins     | `LC中等题`[979. 在二叉树中分配硬币](https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/)
VerticalTraversal   | `LC中等题`[987. 二叉树的垂序遍历](https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/)
LongestZigZag       | `LC中等题`[1372. 二叉树中的最长交错路径](https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/)
GoodNodes           | `LC中等题`[1448. 统计二叉树中好节点的数目](https://leetcode.cn/problems/count-good-nodes-in-binary-tree/)
