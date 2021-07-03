import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第62题
 * @author: Mr.Sun
 * @create: 2021-07-03 08:24
 **/
/*
*
* 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
* 求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。


* */
public class JianZhi_62 {

//思路：用链表表示圆环，当指针超过链表长度时 对指针求余数
class Solution {
    public int lastRemaining(int n, int m) {
        // 创建一个ArraryList模拟链表,链表的长度为n
        List<Integer> list = new ArrayList<Integer>(n);
        // 将 0——n-1放入链表
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while(n>1){
            index = (index+m-1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}


    /*
    *
       K神题解：将自身和自身或多个自身拼接的数组表示环形结构
    *          直到只剩下一个元素位置，其下标为 0
    *          对最后一轮（从 i=2 开始）最后剩下元素的坐标进行计算 :
    *                  (1)补上m个元素，计算索引值(模上当前元素的个数)
    *                  index = (index+m)%i；
    *                  (2)直到 i=n结束，此时的 index 就是最后一个元素在数字环中的位置，而数组下标是从 0开始的，
    *                  而数字环也是从 0 开始的，所以直接返回索引值即可
    * */



    class Solution001 {
        public int lastRemaining(int n, int m) {
            int index = 0;
            for (int i = 2; i <= n; i++) {
                index = (index+m) % i;
            }
            return index ;

        }
    }






}















