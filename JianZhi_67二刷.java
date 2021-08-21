import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-21 09:46
 **/
public class JianZhi_67二刷 {
    class Solution {
        public int strToInt(String str) {
            String trim=str.trim();
            if(trim==null || trim.length()==0) return 0;
            char[] c=trim.toCharArray();
            int i=1;
            int sign=1;
            int res =0;
            int boundary=Integer.MAX_VALUE/10;
            if(c[0]=='-') sign=-1;
            else if(c[0]!='+') i=0;
            for(int j=i;j<c.length;j++){
                if(c[j]<'0' || c[j]>'9') break;
                if(res<boundary || (res==boundary && (c[j]-'0')<=7))res=res*10+(c[j]-'0');
                else return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            return sign*res ;
        }
    }



@Test
public void test(){
    String str = "   76656";
    String trim = str.trim();
    System.out.println(Integer.MAX_VALUE);

}


}
