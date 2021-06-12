import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 最小的K个数字
 * @author: Mr.Sun
 * @create: 2021-06-12 14:06
 **/
public class JianZhi_40 {
    @Test
    public void test(){
        int[] arr = {1,2,4,3,5};
        Arrays.sort(arr);
        int[] res = new int[3];
        for (int i = 0; i < 3; i++) {
            res[i] = arr[i];
        }
        System.out.println(Arrays.toString(res));

    }

//    交换指定两个下标位置数组的数字
    public int[] swap(int[] arr,int i,int j){
        int temp ;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    @Test
    public void testSwap(){
        int[] arr = {1,2,3,4,5,6};
//        int[] swap = swap(arr, 0, 1);
//        System.out.println(Arrays.toString(swap));


        int[] ints = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(ints));
    }


    public int[] quickSort(int[] arr,int k ,int l, int r){
        int i = l;
        int j = r;
//        处理 k > 数组长度的情况
        if(k > arr.length){
            return arr ;
        }
        while(i < j){
            while(i < j && arr[j] >= arr[l]) j--;
            while(i < j && arr[i] <= arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
//        判断当前的基准数字的索引与 k的关系
        if(k < i){
            quickSort(arr,k,l,i-1);
        }
        if(k > i){
            quickSort(arr,k,i+1,r);
        }
        int[] ints = Arrays.copyOf(arr, k);
        return ints ;
    }


    public int[] testTopK(int[] arr ,int k){
        return quickSort(arr,k,0,arr.length-1);
    }



//测试输出数组的大小前 K 个数字
    @Test
public void TestTopK(){
        int[] arr = {1,3,6,2,4,1,9,4};
        int k =4;
        System.out.println(Arrays.toString(testTopK(arr, k)));
    }

}
