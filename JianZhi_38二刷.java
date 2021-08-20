import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-15 09:25
 **/
public class JianZhi_38二刷 {
    class Solution {
        List<String> list =new ArrayList<String>();
        char[] c;
        public String[] permutation(String s) {
            c=s.toCharArray();
            dfs(0);
            return list.toArray(new String[0]);
        }
        public void dfs(int x){
            if(x==c.length-1){
                list.add(String.valueOf(c));
                return ;
            }
            Set<Character> set = new HashSet<Character>();
            for(int i=x;i<c.length;i++){
                if(set.contains(c[i]))continue;
                set.add(c[i]);
                swap(i,x);
                dfs(x+1);
                swap(i,x);
            }

        }
        public void swap(int a,int b){
            char temp=c[a];
            c[a]=c[b];
            c[b]=temp;
        }



    }
}
