import java.util.*;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第59题
 * @author: Mr.Sun
 * @create: 2021-06-14 18:26
 **/
/*
*请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]

* */
public class JianZhi_59II {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(5);

    }
/*
* 双端队列：本题使用到的API：
*
* dequeue.peekFirst()  /dequeue.getFirst()获取队首元素但不删除
* dequeue.peekLast()   /dequeue.getLast() 获取队尾元素但不删除
* dequeue.removeFirst()  删除队首元素
* dequeue.removeLast()   删除队尾元素
* dequeue.addFirst() /dequeue.offerFirst()     将元素添加在队首
* dequeue.addLast()  /dequeue.offerLast()    将元素添加在队尾
* */
}
class MaxQueue {
    private  Queue<Integer> queue;
    private  Deque<Integer> dequeue;
    public MaxQueue() {
      queue = new LinkedList<>();
      dequeue = new LinkedList<>();
    }

    public  int max_value() {
        if (dequeue.isEmpty()){
            return -1;
        }
        return dequeue.peek();
    }

    public  void push_back(int value) {
        queue.add(value);
       while(!dequeue.isEmpty() && dequeue.peekLast()<value){
           dequeue.removeLast();
       }
       dequeue.add(value);
    }

    public  int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int poll = queue.poll();
        if (poll == dequeue.peekFirst()){
            dequeue.poll();
        }
        return poll;
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */