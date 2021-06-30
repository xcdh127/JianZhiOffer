/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第51题
 * @author: Mr.Sun
 * @create: 2021-07-01 07:55
 **/
/*
* 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
* 输入一个数组，求出这个数组中的逆序对的总数。

示例 1:

输入: [7,5,6,4]
输出: 5
 
* */
public class JianZhi_51 {
    class Solution {
        int res ;
        int[] temp ;
        int[] nums;

        public int reversePairs(int[] nums) {
            this.nums = nums;
            temp = new int[nums.length];
            return recur(0, nums.length-1);
        }

        public int recur(int l,int r){
            // 当将数组分成每一部分只有一个元素，停止划分；
            if(l>=r) return res;
            // 获取中点
            int m = (l+r)/2;
            int res = recur(l, m)+recur(m+1, r);
            // 创建辅助数组temp,存放当前较小的数字
            for(int k =l;k<=r;k++){
                temp[k] = nums[k];
            }
            // 合并过程
            // 定义两个指针，i指向前一个数组的首元素，j指向后一个数组的首元素
            int i =l;
            int j = m+1;
            for(int k =l;k<=r;k++){
                // 将后面数组放入时，有两种情况
                // （1）前面数组的指针指完了
                // （2）前面数组当前指的数字大于后面数组当前值指的数字
                if(i==m+1){
                    nums[k] = temp[j++];
                }
                // 当前一个数组中的当前数字小于后面数组的当前数字，将前一个数组的元素放入原数（nums）组中,并且指针后移（i++）
                // 这种情况是正序，前面数字就应该小于后面数字
                // 还有一种情况将前面数字放入，那就是后面数组指针完了（j=r+1）
                else if(j==r+1 || temp[i]<=temp[j] ){
                    nums[k] = temp[i++];
                }

                else{
                    nums[k] = temp[j++];
                    res += m-i+1 ;
                }
            }
            return res ;
        }

    }


}
