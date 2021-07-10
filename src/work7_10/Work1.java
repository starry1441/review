package work7_10;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -10
 * Time: 11:30
 */
public class Work1 {

    //On
    public static int getIndex(int[] arr,int b) {
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    //二分，一般
    public static int getIndex2(int[] arr,int b) {
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        int index = -1;
        while (left < right) {
            mid = (left+right)/2;
            if (arr[mid] > b) {
                right = mid-1;
            }else if (arr[mid] < b){
                left = mid+1;
            }else {
                index = mid;
                break;
            }
        }
        if (index != -1) {
            for (int i = index;i < arr.length; i++) {
                if (arr[i] != b) {
                    i--;
                    return i;
                }
            }
        }
        return -1;
    }

    //二分，牛逼，找>b的第一个位置，然后--
    public static int getIndex3(int[] arr,int b) {
        int left = 0;
        int right = arr.length-1;
        int index = -1;
        if (arr[right] == b) {
            return right;
        }
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] > b) {
                right = mid-1;
                index = mid;
            }else {
                left = mid+1;
            }
        }
        return --index;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,4,5,5,5,6,8,8,8};
        int result = getIndex3(arr,8);
        System.out.println(result);
    }

}
