package work8_9;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -09
 * Time: 15:48
 */
public class Work2 {

    public String LCS (String str1, String str2) {
        int[] dp = new int[str1.length()+1];
        dp[0] = 0;
        int count = 0;
        int max = 0;
        int[] res = new int[2];
        for(int i = 1; i < dp.length; i++) {
            String tmp = str1.substring(dp[i-1],i);
            if(str2.contains(tmp)) {
                dp[i] = dp[i-1];
                count++;
                if(count > max) {
                    max = count;
                    res[0] = dp[i];
                    res[1] = i;
                }
            }else {
                i = dp[i-1]+1;
                dp[i] = i;
                count = 0;
            }
        }
        return str1.substring(res[0],res[1]);
    }

    public int[][] LCS2 (String str1, String str2) {
        int max = 0;
        int index = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(dp[i+1][j+1] > max) {
                        max = dp[i+1][j+1];
                        index = i;
                    }
                }else {
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
//        String res = a.LCS("B1Nfnz4z51qrGNKT3xImT141NY92514w8AF5q1sul7MVNFZnGengc03vO912lFftHDkWpMwWN0SY4pXO1QLji18ujkZV4vr449Wo495WOyIXiO4C9M5L7hQ4tX9ePvV5ohnX00e4mOW28xO968cdR266Ej5M","MV3Et2Q4x4YFlN304p5oLJzVT5zdfz8X83srj64mAx18Ai8kE82aF4so17uR3tD7Nch9CO775WHeVD166zgogKQAj4y04EjJ6Mc23Uvmt11NY92514w8AF5q1sul7MVNFZndJq1vh7qx45XOwP1k1M9jsbB3MLc9FFoy825lu0Cs9Bh3Xm84p5C36r6USQrF96W0b05RfF308001LpK89056qQ8517YFj4pM");
        int[][] res = a.LCS2("1AB2345CD","12345EFB2");
//        String res = a.LCS("22222","22222");
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
