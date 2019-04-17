# 散列表的算法  
> LC --> leetcode上的题
> 数组：    寻址容易o(1)，插入删除困难o(n)
> 链表：    寻址困难o(n)，插入删除容易o(1)
> 散列表：寻址容易o(1)，插入删除容易o(1)

> 散列函数
> 直接定址法：关键码和地址之间存在某个线性函数。 H(key) = a * key + b。 a和b是常数，需要事先直到 key 是什么
> 除留余数法：选取适当的正整数p， H(key) = key mod p。 
> 平方取中法：421^2 为 177241， 去中间两位72做为哈希值 
> 随机数法：H(key) = random(key)

> 哈希冲突的处理方式
> 再哈希
> 缓冲区：建立一个缓冲区，凡是哈希冲突的都放入缓冲区，如果通过key查找时，发现数据不对，则从缓冲区中查找
> 开放定址法：从发生冲突的位置的下个位置开始找空的位置
> 拉链法：用内容为链表的数组存储值

类名|内容
---|---
BloomFilter         |  布隆过滤器
GroupAnagrams       | `LC中等题`[49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
TopKFrequent        | `LC中等题`[347. 前K个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)
FrequencySort       | `LC中等题`[451. 根据字符出现频率排序](https://leetcode-cn.com/problems/sort-characters-by-frequency/comments/)