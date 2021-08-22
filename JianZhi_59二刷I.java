import org.junit.Test;

import java.util.*;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-22 10:49
 **/
public class JianZhi_59二刷I {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums==null || nums.length==0) return new int[0];
            int n=nums.length;
            int num=0;
            int[] res =new int[n-k+1];
            Deque<Integer> deque=new LinkedList<Integer>();
            for(int i=1-k,j=0;j<n;i++,j++){
                if(i>0 && deque.getFirst()==nums[i-1]) deque.removeFirst();
                while(!deque.isEmpty() && deque.getLast()<nums[j]) deque.removeLast();
                deque.addLast(nums[j]) ;
                if(i>=0) res[num++]=deque.getFirst();
            }
            return res ;
        }
    }
    @Test
    public void test(){
        int[] arr={1,2,3,4,5,6};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = list.toArray(new Integer[0]);

        list.clear();
    }
}
