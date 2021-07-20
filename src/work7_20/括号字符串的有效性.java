package work7_20;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -20
 * Time: 11:38
 */
public class 括号字符串的有效性 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(count < 0 || str.charAt(i) != '(' && str.charAt(i) != ')') {
                System.out.println("NO");
                return;
            }
            if(str.charAt(i) == '(') {
                count++;
            }
            if(str.charAt(i) == ')') {
                count--;
            }
        }
        if(count != 0) {
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }

}
