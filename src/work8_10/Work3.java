package work8_10;

import java.util.jar.JarOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -10
 * Time: 14:29
 */
public class Work3 {

    public static String solve (String str) {
        StringBuilder s = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--) {
            s.append(str.charAt(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String str = "abcd";
        solve(str);
    }

}
