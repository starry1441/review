package work8_6;

/**
 * Created with IntelliJ IDEA.
 * Description:最小的K个数
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=190&&tqId=35976&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * User: starry
 * Date: 2021 -08 -06
 * Time: 11:32
 */
public class Work1 {

    //快排思路
    public int findKth(int[] a, int n, int K) {
        return quick(a,0,n-1,K);
    }
    public int quick(int[] arr,int left,int right,int k) {
        int piv = sort(arr,left,right);
        if(piv == k-1) {
            return arr[piv];
        }else if(piv > k-1) {
            return quick(arr,left,piv-1,k);
        }else {
            return quick(arr,piv+1,right,k);
        }
    }
    public int sort(int[] arr,int left,int right) {
        int piv = arr[left];
        while(left < right) {
            while(left < right && arr[right] <= piv) {
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] >= piv) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = piv;
        return left;
    }

    //堆排思路
    public int findKth2(int[] a, int n, int K) {
        heapSort(a);
        return a[K-1];
    }
    public void heapSort(int[] arr) {
        createSmallHeap(arr);
        int end = arr.length-1;
        while(end >= 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            end--;
            adjustDown(arr,end,0);
        }
    }
    public void createSmallHeap(int[] arr) {
        int len = arr.length-1;
        int parent = (len-1)/2;
        while(parent >= 0) {
            adjustDown(arr,len,parent);
            parent--;
        }
    }
    public void adjustDown(int[] arr,int len,int parent) {
        int child = parent*2+1;
        while(child <= len) {
            if(child+1 <= len && arr[child+1] < arr[child]) {
                child++;
            }
            if(arr[child] < arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        int[] arr = {10,10,9,9,8,7,5,6,4,3,4,2};
        System.out.println(a.findKth(arr,12,3));
    }

}
