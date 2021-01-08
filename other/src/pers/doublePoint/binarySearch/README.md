### 二分查找

#### 二分查找算法模版
```java
int binarySearch(int[] nums, int target) {
    
    int left = 0, right = ...;
    
    while (...) {
        
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...;
        } else if (nums[mid] > target) {
            right = ...;
        }
    }
    return ...;
}
```
> 注意不要出现else，把所有情况都列出

### 二分查找的细节
#### 确定搜索区间
如果 left = 0, right = nums.length-1;<br>
那么搜索区间应该是[left, right]，搜索完整个区间即可退出，<br>
因此while(left <= right)<br>
而left和right应该是<br>
left = mid + 1; right = mid - 1;<br>
这样分割后区间依然是[left, right]

如果 left = 0, right = nums.length;<br>
那么搜索区间应该是[left, right)，<br>
因此while(left < right)退出 <br>
而left和right应该是<br>
left = mid + 1; right = mid;<br>
这样分割后区间依然是[left, right)
