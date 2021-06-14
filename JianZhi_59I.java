import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第59题
 * @author: Mr.Sun
 * @create: 2021-06-14 21:57
 **/
public class JianZhi_59I {


    public static void main(String[] args) {

        JianZhi_59I test = new JianZhi_59I();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        int[] ints = test.maxNumber(nums, k);
        System.out.println(Arrays.toString(ints));//[3,3,5,5,6,7]


    }



    public int[] maxNumber(int[] nums,int k){
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        //特殊处理，判空
        if (nums==null ||nums.length==0 ||k==0){
            return new int[0];
        }
        for (int i=1-k,j=0;j<nums.length;i++,j++){

//      当 i > 0 并且从刚刚滑动窗口出去的元素和双端队列队首元素相等时，将队首元素弹出，以保持队列与滑动窗口数据一致
        if (i>0 && nums[i-1]==deque.peekFirst()){
            deque.removeFirst();
        }
//        当队列尾部的数字小于当前刚刚进入滑动窗口的数字时，删除队尾元素，直到队尾元素不小于当前元素
            while(!deque.isEmpty() && nums[j]>deque.peekLast()){
                deque.removeLast();
            }
//            将当前元素放在队首
            deque.addLast(nums[j]);
            if (i>=0){
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
//第一次自己写的代码
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length-k+1;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[length];
        int n = 0 ;
        if(k == 0){
            return new int[0];
        }
        while(n<=length-1){
            for(int i = 0 ; i < k ; i++){
                if(deque.isEmpty()){
                    deque.add(nums[n+i]);
                }
                while(!deque.isEmpty() && nums[n+i]>deque.peekLast()){
                    deque.removeLast();
                }
                deque.add(nums[n+i]);
            }
            res[n++]=deque.peekFirst();
        }
        return res;
    }
}








