/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-11 18:53
 **/
public class JianZhi_33二刷 {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            int i=0;
            int j=postorder.length-1;
            return recur(postorder,i,j);
        }

        public boolean recur(int[] postorder,int i,int j){
            if(i>=j)return true ;
            int m=i;
            while(postorder[m]<postorder[j])m++;
            int p=m;
            while(postorder[p]>postorder[j])p++;
            return j==p && recur(postorder,i,m-1) && recur(postorder,m,j-1);
        }
    }
}
