import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-15 10:32
 **/
public class JianZhi_45二刷 {

    class Solution {
        int[] nums;
        int[] temp;
        public int reversePairs(int[] nums) {
            this.nums=nums;
            temp=new int[nums.length];
            return  mergeSort(0,nums.length-1);

        }
        public int mergeSort(int left,int right){
            if(left>=right)return 0;
            int mid = (left+right)/2;
            int res = mergeSort(left,mid)+mergeSort(mid+1,right);
            for(int k=left;k<=right;k++){
                temp[k]=nums[k];
            }
            int i=left;
            int j=mid+1;
            for(int k=left;k<=right;k++){
                if(i==mid+1){
                    nums[k]=temp[j];
                    j++;
                }
                else if(j==right+1){
                    nums[k]=temp[i];
                    i++;
                }
                else if(temp[i]<=temp[j]){
                    nums[k]=temp[i];
                    i++;
                }
                else{
                    res+=mid-i+1;
                    nums[k]=temp[j];
                    j++;
                }
            }
            return res ;
        }

    }
    @Test
    public void test(){
        String[] nums={"4","56","98"};
        System.out.println(Arrays.toString(nums));
    }


}
