/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-15 10:07
 **/
public class JianZhi_21二刷 {
    class Solution {
        int[] nums;
        public int[] exchange(int[] nums) {
            this.nums=nums;
            int i=0;
            int j=nums.length-1;
            while(i<j){
                while(i<j && !isOdd(nums[j]))j--;
                while(i<j && isOdd(nums[i]))i++;
                swap(i,j);
            }
            return nums ;
        }
        public boolean isOdd(int n){
            if((n&1)==1)return true;
            return false ;
        }
        public void swap(int a,int b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }
    }

    class Solution01 {
        int[] nums;
        public int[] exchange(int[] nums) {
            this.nums=nums;
            int i=0;
            int j=nums.length-1;
            while(i<j){
                while(i<j && (nums[j]&1)==0)j--;
                while(i<j && (nums[i]&1)==1)i++;
                int temp=nums[i] ;
                nums[i]=nums[j];
                nums[j]=temp;
            }
            return nums ;
        }

    }



}
