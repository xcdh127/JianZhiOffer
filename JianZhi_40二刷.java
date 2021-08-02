import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description: 666
 * @author: Mr.Sun
 * @create: 2021-08-02 07:11
 **/
public class JianZhi_40二刷 {

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if(k>=arr.length) return arr ;
            int l = 0;
            int r = arr.length-1 ;
            return QSort(arr, l, r, k);
        }

        public int[] QSort(int[] arr,int l,int r,int k){
//当子数组的长度等于1时，结束
            int i = l ;
            int j = r ;
            while(i<j){
                while(i<j && arr[j]>=arr[l]) j--;
                while(i<j && arr[i]<=arr[l]) i++;
                swap(arr,i,j);
            }
            swap(arr,i,l);
            if(i<k) return QSort(arr, i+1, r,k);
            if(i>k) return QSort(arr, l, i-1,k);
            return Arrays.copyOf(arr,k);
        }
        public void swap(int[] arr,int a,int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b]=temp ;
        }



    }

    }

