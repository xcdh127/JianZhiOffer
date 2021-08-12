import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 58
 * @author: Mr.Sun
 * @create: 2021-08-03 18:55
 **/
    public class JianZhi_58二刷 {
//    "hello world!" --->  "world hello"
    public String reserve(String s){
        StringBuilder sb = new StringBuilder();
//        先处理字符串前后的空格
        s = s.trim();
//        定义两个指针用于返回 子字符串,初始化都指向字符串的尾部
        int j = s.length()-1 ;
        int i = s.length()-1 ;
//        指针i向前指，直到直到第一个空格
        while(i>=0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
//            截取i到j部分的字符串
//            注意：substirng()函数截取区间是[a,b)
            String substring = s.substring(i + 1, j + 1);
//            将截取到的子字符串放入到StringBuilder中,并在最后拼接上空格
            sb.append(substring);
            sb.append(' ');
//            遍历空格部分直到遇到第一个非空字符
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
//            将指针j指向下一个要加入的子字符串
            j = i;
        }
        String string = sb.toString();
        return string.trim();
    }
    }









//    @Test
//    public void test(){
//        String s = "hello world!";
//        System.out.println(s.length());
//
//        StringBuilder sb  = new StringBuilder();
//        sb.append("我们中国的孩子");
//        System.out.println(s.substring(2, 5));
//
//    }




