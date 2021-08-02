package work7_30;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:复习排序算法
 * User: starry
 * Date: 2021 -07 -31
 * Time: 16:33
 */
public class Sort {

    //选择排序，最好O（n2），最坏O（n2），平均O（n2），不稳定
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //冒泡排序，最好O（n），最坏O（n2），平均O（n2），稳定
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    isSort = false;
                }
            }
            if (isSort) break;
        }
    }

    //插入排序，最好O（n），最坏O（n2），平均O（n2），稳定
    public static void insertSort(int[] arr) {
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }

    //希尔排序，最好O（n），最坏O（n2），平均O（1.3-1.5n），不稳定
    public static void shellSort(int[] arr) {
        int[] dll = {5,3,1};
        for (int i = 0; i < dll.length; i++) {
            shell(dll[i],arr);
        }
    }
    public static void shell(int gap, int[] arr) {
        int tmp;
        for (int i = gap; i < arr.length; i++) {
            tmp = arr[i];
            int j;
            for (j = i-gap; j >= 0; j-=gap) {
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }

    //堆排序，最快O（nlogn），最慢O（nlogn），平均O（nlogn），不稳定
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length-1;
        while(end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            end--;
            adjustDown(arr,0,end);
        }
    }
    public static void createHeap(int[] arr) {
        int len = arr.length-1;
        int parent = (len-1)/2;
        for (int i = parent; i >= 0; i--) {
            adjustDown(arr,i,len);
        }
    }
    public static void adjustDown(int[] arr, int parent, int len) {
        int child = parent*2+1;
        while(child <= len) {
            if (child+1 <= len && arr[child+1] > arr[child]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
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

    //快速排序，最快O（nlogn），最慢O（n2），平均O（nlogn），不稳定，空间O（logn-n2）
    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        quick(arr,low,high);
    }
    public static void quick(int[] arr,int low, int high) {
        if (low >= high) return;
        int index = sort(arr,low,high);
        quick(arr,low,index);
        quick(arr,index+1,high);
    }
    public static int sort(int[] arr, int low, int high) {
        int piv = arr[low];
        while(low < high) {
            while (low < high && arr[high] > piv) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < piv) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = piv;
        return low;
    }

    //归并排序，最好O（nlogn），最坏O（nlogn），平均O（nlogn），稳定，空间O（n）
    public static void mergeSort(int[] arr) {
        part(arr,0,arr.length-1);
    }
    public static void part(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low+high)/2;
        part(arr,low,mid);
        part(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr,int low,int mid,int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmp = new int[high-low+1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] <= arr[s2]) {
                tmp[i++] = arr[s1++];
            } else {
                tmp[i++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[i++] = arr[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = arr[s2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[low+j] = tmp[j];
        }
    }



    public static void main(String[] args) {
        int[] arr = {3,5,1,4,8,2,7,6};
//        selectSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        heapSort(arr);
//        quickSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
