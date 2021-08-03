import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description: 57
 * @author: Mr.Sun
 * @create: 2021-08-03 18:37
 **/
public class JianZhi_57II二刷 {
//双指针问题
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int i=1;
            int j=2;
            List<int[]> res = new ArrayList<int[]>();
            while(i<=target/2){
                int[] arr = new int[j-i+1];
                int m  =0;
                int sum = 0;
                for(int k =i;k<=j;k++){
                    sum+= k;
                    arr[m++]=k;
                }
                if(sum>target){
                    i++;
                }
                if(sum<target) j++;
                if(sum==target){
                    res.add(arr);
                    i++ ;
                }
            }
            return res.toArray(new int[0][]);
        }

    }

}
