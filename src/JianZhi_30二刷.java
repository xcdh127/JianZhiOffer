import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: LeetCodeJavaTest
 * @description: 6666
 * @author: Mr.Sun
 * @create: 2021-08-01 19:50
 **/
public class JianZhi_30二刷 {

    class MinStack {
        Stack<Integer> stack ;
        Deque<Integer> deque ;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
            deque = new LinkedList<Integer>();
        }
        public void push(int x) {
            stack.push(x) ;
            if(deque.isEmpty() || x<=deque.peekFirst()){
                deque.addFirst(x);
            }
        }

        public void pop() {
            int val = stack.pop();
            if(val==deque.peekFirst()){
                deque.removeFirst();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return deque.peekFirst();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */




}
