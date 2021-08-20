import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 03
 * @author: Mr.Sun
 * @create: 2021-07-31 09:24
 **/
public class JianZhi_03二刷 {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[i]==nums[nums[i]]){
                return nums[i];
            }
            exchange(i,nums[i],nums);
//             int temp = nums[i];
//             nums[i]=nums[temp];
//             nums[temp]=temp;
        }
        return -1 ;
    }

    public void exchange(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    @Test
    public void test(){
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }

}
