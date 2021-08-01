import java.util.Stack;

/**
 * @program: LeetCodeJavaTest
 * @description: 666
 * @author: Mr.Sun
 * @create: 2021-08-01 19:51
 **/
public class JianZhi_31二刷 {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[]  popped) {
//遍历popped的索引
            int i = 0 ;
            Stack<Integer> stack = new Stack<Integer>();
            for(int num : pushed){
                stack.push(num);
                while(!stack.isEmpty() && stack.peek() == popped[i]){
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }



}
