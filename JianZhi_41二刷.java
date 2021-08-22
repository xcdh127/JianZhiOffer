import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-22 07:39
 **/
public class JianZhi_41二刷 {
    class MedianFinder {
        List<Integer> list ;
        /** initialize your data structure here. */
        public MedianFinder() {
            list= new ArrayList<Integer>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            list.sort(Comparator.naturalOrder());
            if(list.size()%2==1) return list.get(list.size()/2)/1.0;
            else return (list.get(list.size()/2-1)+list.get(list.size()/2))/2.0;
        }

    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    @Test
    public void test(){
        List<Integer> list =new ArrayList<>();
        list.sort();
    }
}
