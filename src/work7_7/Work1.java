package work7_7;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -07
 * Time: 10:58
 */
import java.util.*;

public class Work1 {
    public static double half(double input) {
        double min = 0;
        double mid = input;
        double max = 0;
        while(max - min > 0.001) {
            mid = (max + min)/2;
            if(mid*mid*mid > input) {
                max = mid;
            }else if(mid*mid*mid < input) {
                min = mid;
            }else {
                return mid;
            }
        }
        return mid;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            double input = in.nextDouble();
            double result = half(input);
            System.out.println(result);
        }
    }
}
