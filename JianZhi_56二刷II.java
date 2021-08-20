/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:55
 **/
public class JianZhi_56二刷II {
    class Solution {
        public int singleNumber(int[] nums) {
            int[] arr = new int[32];
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<32;j++){
                    arr[j]+=nums[i]&1;
                    nums[i]>>>=1;
                }
            }
            for(int j=0;j<32;j++){
                arr[j]%=3;
            }
            int res=0;
            for(int j=0;j<32;j++){
                res<<=1;
                res|=arr[31-j];
            }
            return res ;
        }
    }



}
