package work8_8;

/**
 * Created with IntelliJ IDEA.
 * Description:NC22 合并两个有序的数组
 * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=190&&tqId=35185&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * User: starry
 * Date: 2021 -08 -08
 * Time: 11:03
 */
public class Work3 {

    //开辟新数组
    public void merge(int A[], int m, int B[], int n) {
        int[] arr = new int[m+n];
        int a = 0;
        int b = 0;
        int i = 0;
        while(a < m && b < n) {
            if(A[a] < B[b]) {
                arr[i++] = A[a++];
            }else {
                arr[i++] = B[b++];
            }
        }
        while(a < m) {
            arr[i++] = A[a++];
        }
        while(b < n) {
            arr[i++] = B[b++];
        }
        for(int j = 0; j < arr.length; j++) {
            A[j] = arr[j];
        }
    }

    //不开辟新数组，从后向前遍历
    public void merge2(int A[], int m, int B[], int n) {
        int a = m-1;
        int b = n-1;
        int i = m+n-1;
        while(a >= 0 && b >= 0) {
            A[i--] = A[a] > B[b] ? A[a--] : B[b--];
        }
        while(b >= 0) {
            A[i--] = B[b--];
        }
    }

}
