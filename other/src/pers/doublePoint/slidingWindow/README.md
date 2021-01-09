### 滑动窗口

#### 算法模版
```java
int left = 0, right = 0;

while (right < s.size) {
    // 增大窗口
    window.add(s[right]);
    right++;
    
    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

#### 详细算法模版
```java
void slidingWindow(string s, string t) {
    
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;
    
    int left = 0, right = 0;
    int valid = 0;
    while (right < s.size()) {
        // c是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        
        // 进行窗口内数据的一系列更新
        ...
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            
            // 进行窗口内数据的一系列更新
            ...
        }
        
    }
    
}
```

#### 需要思考的问题
* 当移动right扩大窗口，即加入字符时，应该更新哪些数据？
* 什么条件下，窗口应该暂停扩大，开始移动left缩小窗口？
* 当移动left缩小窗口，即移出字符时，应该更新哪些数据？
* 要的结果应该在扩大窗口时还是缩小窗口时进行更新？