/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (44.39%)
 * Likes:    425
 * Dislikes: 0
 * Total Accepted:    35.1K
 * Total Submissions: 76.5K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 * );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */
import java.util.*;
// @lc code=start
class LRUCache {
    Map<Integer,Node>map;
    // Map<Integer,Integer>map1;
    Node head,tail;
    int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>(capacity);
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.pre=head;
        this.capacity=capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))return -1;
        Node p=map.get(key);
        p.pre.next=p.next;
        p.next.pre=p.pre;
        p.pre=head;
        p.next=head.next;
        head.next=p;
        p.next.pre=p;
        return p.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.get(key).val=value;
            get(key);
        }else{
            if (map.size()==capacity){
                Node p=tail.pre;
                p.pre.next=p.next;
                p.next.pre=p.pre;
                map.remove(p.key);
            }
            Node p=new Node(key, value);
            map.put(key, p);
            p.pre=head;
            p.next=head.next;
            head.next=p;
            p.next.pre=p;
        }
    }
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

