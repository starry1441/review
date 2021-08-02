package work8_1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -01
 * Time: 15:41
 */
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String[] s1 = str.split(":");
//        String[] num = s1[0].split(",");
//        int k = Integer.parseInt(s1[1]);
//        int[] arr = new int[num.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(num[i]);
//        }
//        float pre = 0f;
//        float now = 0f;
//        float max = 0f;
//        float avg = 0f;
//        //arr数字数组，k窗口大小
//        int i = 0;
//        int j = k-1;
//        while(j < arr.length) {
//            float sum = 0f;
//            for (int l = i; l <= j; l++) {
//                sum += arr[l];
//            }
//            avg = sum/k;
//            if (i != 0) {
//                now = (avg-pre)/pre;
//                if(now > max) {
//                    max = now;
//                }
//            }
//            pre = avg;
//            i++;
//            j++;
//        }
//        max = max*100;
//        System.out.println(String.format("%.2f",max) + "%");
//    }
//}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String st = str.substring(1,str.length()-1);
        String[] s = st.split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] res = new int[arr.length];
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
            if (arr[i] != 0) {
                res[i] = -1;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] == 0) {
                for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        entry.setValue(entry.getValue()-1);
                        res[i] = entry.getKey();
                        break;
                    }
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(Arrays.toString(new int[0]));
                return;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}