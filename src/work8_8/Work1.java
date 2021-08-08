package work8_8;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:NC41 最长无重复子数组
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=190&&tqId=35220&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * User: starry
 * Date: 2021 -08 -08
 * Time: 10:46
 */
public class Work1 {

    public int maxLength (int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(i < arr.length) {
            if(map.containsKey(arr[i])) {
                j = Math.max(j,map.get(arr[i])+1);
            }
            map.put(arr[i],i);
            max = Math.max(max,i-j+1);
            i++;
        }
        return max;
    }

}
