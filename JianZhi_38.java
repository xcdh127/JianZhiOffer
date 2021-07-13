import org.junit.Test;

import java.util.*;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第38题
 * @author: Mr.Sun
 * @create: 2021-07-13 16:46
 **/
/*
* 输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

* */
public class JianZhi_38 {

    /*
    K神题解：深度优先遍历问题
             首先将第一位固定，其他位置进行全排列，方法是将第一个位置的字符与其后面的字符交换位置。
             问题主要出现在字母重复，这时候要进行剪枝操作，定义一个set集合，当重复存入字符的时候，跳过这一次的遍历。
             当固定位置到达最后一位时，将这个字符串保存的结果集合中，并且停止遍历操作。
    */
    List<String> res = new ArrayList<>();
    char[] c;

    public String[] permutation(String s) {
        c= s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x){
//        如果当前的固定位置到达了最后一位，那么将字符串存入结果集合中
        if (x == c.length-1){
            res.add(String.valueOf(c));
            return;
        }
//        用于判断元素是否重复的set集合
        Set<Character> set = new HashSet<>();
        for (int i =x;i<c.length;i++){
//            如果当前的元素已经包含在了set集合中，就直接跳过这一次的全排列
            if (set.contains(c[i]))continue;
//            将当前元素添加到set集合中
            set.add(c[i]);
//            固定第x位数字
            swap(i,x);
//            对第x+1位数字进行全排列
            dfs(x+1);
//            排列完毕后，恢复交换之前的位置
            swap(i,x);
        }
    }




    public void swap(int a,int b){
        char temp = c[a];
        c[a]= c[b];
        c[b]=temp;
    }


    @Test
    public void test(){
        String s = "abc";
        System.out.println(permutation(s));


    }




}
