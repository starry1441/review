package work8_11;

/**
 * Created with IntelliJ IDEA.
 * Description:NC17 最长回文子串
 * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=190&&tqId=35207&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * User: starry
 * Date: 2021 -08 -11
 * Time: 20:15
 */
public class Work1 {

    //动规
    public int getLongestPalindrome(String A, int n) {
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        //i左，j右
        for(int j = 0; j < n; j++) {
            for(int i = 0; i <= j; i++) {
                if(A.charAt(i) == A.charAt(j)) {
                    if(j-i <= 2) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j] && j-i+1 > max) {
                        max = j-i+1;
                    }
                }
            }
        }
        return max;
    }

    //扩散法
    public int getLongestPalindrome2(String A, int n) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            int one = spread(A,i,i);
            int two = spread(A,i,i+1);
            int len = one > two ? one : two;
            if(len > max) max = len;
        }
        return max;
    }
    public int spread(String A,int left,int right) {
        while(left >= 0 && right <= A.length()-1) {
            if(A.charAt(left) == A.charAt(right)) {
                left--;
                right++;
            }else break;
        }
        return right-left-1;
    }

}
