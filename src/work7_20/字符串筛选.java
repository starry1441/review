package work7_20;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -20
 * Time: 11:50
 */
public class 字符串筛选 {

    public String unique_string (String s) {
        ArrayList<Character> list = new ArrayList();
        for(int i = 0; i < s.length(); i++) {
            if(!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        for(char c : list) {
            str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args) {

    }

}
