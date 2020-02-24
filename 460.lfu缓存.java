/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU缓存
 *
 * https://leetcode-cn.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (33.68%)
 * Likes:    79
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 7.5K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * 
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) -
 * 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * 
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * 
 * 示例：
 * 
 * 
 * LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

import java.util.*;
// @lc code=start
class LFUCache {
    int cap;
    Map<Integer,Integer> map1=new HashMap<Integer,Integer>();
    // key-myclass
    Map<Integer,Myclass> map2=new HashMap<Integer,Myclass>();
    // frequence->head
    Map<Integer,Myclass> map3=new HashMap<Integer,Myclass>();
    // Map<Myclass,Integer> map4=new HashMap<Myclass,Integer>();
    List<Myclass> list;
    Myclass head,tail;
    int num;
    public LFUCache(int capacity) {
        cap=capacity;
        head=new Myclass(0);
        // Myclass tmp=new Myclass(1);
        // tmp.next=head;
        map3.put(0,head);
        // add(head);
        num=0;
    }
    public void add(Myclass m){
        int val=m.val;
        // if (!map3.containsKey(val-1)){
        //     m.pre.next=m.next;
        //     m.next.pre=m.pre;
        //     return;
        // }
        Myclass last;
        // m.next=last.next;
        // m.pre=last;
        // last.next=m;
        // if(val>1){
        //     last.val--;
        //     if (last.val==0){
        //         map3.remove(val-1);
        //     }
        // }
        if(map3.containsKey(val)){
            last=map3.get(val);
        }else if (map3.containsKey(val-1)){
            last=map3.get(val-1);
        }else{
            last=m.pre;
        }
        map3.put(val,m);
        m.next=last.next;
        if (last.next!=null)m.next.pre=m;
        last.next=m;
        m.pre=last;
    }
    public void remove(Myclass m){
        int val=m.val;
        // Myclass last=map3.get(val);
        m.pre.next=m.next;
        // m.next.pre=m.pre;
        if (m.next!=null)m.next.pre=m.pre;
        if (map3.get(val)==m){
            if (m.pre.val<m.val) {
                map3.remove(m.val);
            }else map3.put(val, m.pre);
        }
    }
    public int get(int key) {
        System.out.println(key);
        if (map1.containsKey(key)){
            Myclass m=map2.get(key);
            remove(m);
            m.val++;
            add(m);            
            return map1.get(key);
        }else return -1;
    }
    
    public void put(int key, int value) {
        if (cap==0) return;
        System.out.println(key+" "+value);
        if (!map1.containsKey(key)){
            num++;
            if (num==cap+1){
                System.out.println("delete "+head.next.key);
                map1.remove(head.next.key);
                map2.remove(head.next.key);
                remove(head.next);
                // int tmp=map4.get();
                num--;
            }
            map1.put(key, value);
            Myclass m=new Myclass(1);
            m.key=key;
            map2.put(key, m);
            // map4.put(m,key);
            add(m);
        }else{
            map1.put(key, value);
            get(key);
        }

    }
    private class Myclass{
        int val;
        int key;
        Myclass pre;
        Myclass next;
        // Myclass in;
        Myclass(int v){
            val=v;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

