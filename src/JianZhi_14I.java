import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第14题第1小题
 * @author: Mr.Sun
 * @create: 2021-07-26 18:44
 **/
public class JianZhi_14I {


        public int cuttingRope(int n) {
            //本题使用贪心算法，如何贪心？我们根据公式，每一次截取相等长度，
            //据理论支撑，每一次截取长度为 3 时，可以获得最大的乘积。
            // 开启贪心模式：每一次都截取长度为 3 ，最后一段的长度可能为0,1,2
            // 分情况讨论：
            //（1） 当最后结果为 0 时，乘积为3的m次幂；
            //（2） 当最后结果为 1 时，因为1*3 < 2*2 将一个1和3换成2和2
            //    结果为 3 的m-1次幂*2*2 ;
            // (3)  当最后结果为 2 时，结果为3 的m次幂*2;
//     小于3的数字其实不需要在分割，但是题目中说必须切一刀，所以特殊处理 N=1 和 N=2 的2情况
            if(n == 2) return 1 ;
            if(n == 3) return 2 ;
            int m = n/3 ;
            int res = 0 ;
            if(n % 3 == 0)  res = (int)Math.pow(3,m) ;
            if(n % 3 == 1)  res = (int)Math.pow(3,m-1)*2*2 ;
            if(n % 3 == 2)  res = (int)Math.pow(3,m)*2 ;

            return res ;
        }

        @Test
        public void test(){
            System.out.println(cuttingRope(9));

        }




}
