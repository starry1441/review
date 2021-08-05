package work8_5;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:["((()))","(()())","(())()","()(())","()()()"]
 *             ["()"]
 * User: starry
 * Date: 2021 -08 -05
 * Time: 20:16
 */
public class Work1 {

    //思路：只需要判断左右括号剩余个数，就可以判断该组合是否正确
    //剩余左括号数 > 剩余右括号数 ，则不是括号匹配的格式，进行回溯

    int count = 0;  //记录正确括号匹配的个数
    public int count_KuoHao(int a) {
        dfs(a,a);   //参数：（剩余所括号数，剩余右括号数）
        return count;
    }
    public void dfs(int left,int right) {
        if(left > right) return;    //当剩余左括号 > 剩余右括号，不是正确格式，回溯
        if(left == 0 && right == 0) count++;    //剩余左括号数 和 剩余右括号数 都为0，记录一个正确括号匹配个数
        if(left > 0) dfs(left-1,right);    //如果有剩余左括号，则加入左括号，剩余左括号-1
        if(right > 0) dfs(left,right-1);  //如果有剩余右括号，则加入右括号，剩余右括号-1
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        System.out.println("一对括号构成个数：" + a.count_KuoHao(1));
        Work1 b = new Work1();
        System.out.println("两对括号构成个数：" + b.count_KuoHao(2));
        Work1 c = new Work1();
        System.out.println("三对括号构成个数：" + c.count_KuoHao(3));
    }

}
