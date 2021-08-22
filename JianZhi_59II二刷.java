import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-22 14:54
 **/
public class JianZhi_59II二刷 {
    class MaxQueue {
        Queue<Integer> queue ;
        Deque<Integer> deque ;
        public MaxQueue() {
            queue = new LinkedList<Integer>();
            deque = new LinkedList<Integer>();
        }

        public int max_value() {
            if(deque.isEmpty()) return -1;
            return deque.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while(!deque.isEmpty() && deque.getLast()<value){
                deque.removeLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) return -1 ;
            if(deque.getFirst().equals(queue.peek())) deque.removeFirst();
            return queue.remove();
        }
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
    @Test
    public void test(){
        Deque<Integer> deque = new LinkedList<>();

    }


}
