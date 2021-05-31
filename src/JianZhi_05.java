import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 666
 * @author: Mr.Sun
 * @create: 2021-05-26 11:44
 **/
public class JianZhi_05 {
    public static void main(String[] args) {

        byte[] bytes = "sss".getBytes();
        String str = "ss 44 88";
        String str1 = "20%";
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(s));
        for (int i = 0; i < s.length; i++) {
            if (i==s.length-1){
                sb.append(s[i]);
            }else{
                sb.append(s[i]+"20%");
            }
        }
        System.out.println(sb);
    }
    public void test(){
        char[] str = new char[6];
        String str3 = "eerre";
        char c = str3.charAt(2);
    }
}
