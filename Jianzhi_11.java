/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第11题
 * @author: Mr.Sun
 * @create: 2021-06-28 19:34
 **/
/*
*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
* 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
* 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
*/
public class Jianzhi_11 {
//    二分思想：数组分成两个递增序列，要寻找的数字恰好是两个序列的分界线
//    设置两个指针，分别指向首尾，取中间值与尾部比较，如果大于尾部说明：mid在第一个递增序列中，i=mid+1(mid+1,j)
//                                                如果小于尾部说明：mid在第二个递增序列中，j=m(i,m)
//                                                为什么不是j=m-1:因为 m自己可能就是分界线。
    class Solution {
        public int minArray(int[] numbers) {
            int i=0;
            int j=numbers.length-1;
            while(i<j){
                int mid = (i+j)/2;
                if(numbers[mid]>numbers[j])i=mid+1;
                else if(numbers[mid]<numbers[j])j=mid;
                else j--;//无法判断属于哪个序列，执行j--.
            }
            return numbers[i];
        }
    }
}
