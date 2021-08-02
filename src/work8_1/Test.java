package work8_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -02
 * Time: 20:14
 */
public class Test {

    public String GetXMLValue(String inxml, String path) {
        List<String> list = new ArrayList<>();
        String res = "";
        int m = 0;
        for(int i = 0; i < inxml.length(); i++) {
            if(inxml.charAt(i) == '<') {
                m = i+1;
            }
            if(inxml.charAt(i) == '>') {
                list.add(inxml.substring(m,i));
                if(inxml.charAt(i+1) >= 'a' && inxml.charAt(i+1) <= 'z') {
                    for(int j = i+1; j < inxml.length(); j++) {
                        if (inxml.charAt(j) == '<') {
                            res = inxml.substring(i+1,j);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        String[] ned = path.split("\\.");
        int i;
        for (i = 0; i < ned.length; i++) {
            if (!list.contains(ned[i])) {
                break;
            }
        }
        if (i == ned.length) {
            return res;
        }else {
            return "";
        }
    }

    public int findBalancedIndex(int[] inputArray) {
        int start = 0;
        int end = 0;
        for(int i = inputArray.length-1; i > 0; i--) {
            end += inputArray[i];
        }
        for(int i = 1; i < inputArray.length; i++) {
            start += inputArray[i-1];
            end -= inputArray[i];
            if(start == end) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        String res = test.GetXMLValue("<people><name>shopee</name></people>","people.name");
//        System.out.println(res);
        test.findBalancedIndex(new int[]{1,2,3,4,6});
    }

}
