import java.util.Stack;

/**
 * @program: LeetCodeJavaTest
 * @description: 66
 * @author: Mr.Sun
 * @create: 2021-08-01 19:49
 **/
public class JianZhi_09二刷 {
    class CQueue {
        Stack<Integer> stackA ;
        Stack<Integer> stackB ;
        public CQueue() {
            stackA = new Stack<Integer>();
            stackB = new Stack<Integer>();
        }
        public void appendTail(int value) {
            stackA.push(value);
        }
        public int deleteHead() {
            if(!stackB.isEmpty()){
                return stackB.pop();
            }
            while(!stackA.isEmpty()){
                int val = stackA.pop();
                stackB.push(val);
            }
            if(stackA.isEmpty() && stackB.isEmpty()){
                return -1 ;
            }
            return stackB.pop();
        }
    }
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */



}
