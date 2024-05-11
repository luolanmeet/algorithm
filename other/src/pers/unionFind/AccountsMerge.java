package pers.unionFind;

import java.util.*;

/**
 * 721. 账户合并
 * https://leetcode.cn/problems/accounts-merge/
 * @auther ken.ck
 * @date 2024/5/11 14:25
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // <邮箱，账号id>
        Map<String, Integer> emailToId = new HashMap<>();
        int n = accounts.size();
        UnionFind union = new UnionFind(n);
        // 将同一个用户的所有邮箱放置在同一个连通域
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToId.containsKey(email)) {
                    union.union(i, emailToId.get(email));
                } else {
                    emailToId.put(email, i);
                }
            }
        }

        // 收集同个用户的所有邮箱
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            int id = union.find(entry.getValue());
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            idToEmails.put(id, emails);
        }

        // 构造返回结果，id 转为 用户名
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(entry.getKey()).get(0));
            tmp.addAll(emails);
            res.add(tmp);
        }

        return res;
    }

    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }
    }

    public static void main(String[] args) {
        AccountsMerge obj = new AccountsMerge();
        System.out.println(obj.accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        )));
    }

}
