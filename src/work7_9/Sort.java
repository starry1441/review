package work7_9;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -07 -09
 * Time: 19:40
 */
public class Sort {

    //选择排序,最好O(n2),最坏O(n2),平均O(n2),不稳定
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //冒泡排序，最好O(n),最坏O(n2),平均O(n2),稳定
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
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

    //插入排序,最快O(n),最慢O(n2),平均O(n2),稳定
    public static void insertSort(int[] arr) {
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }

    //希尔排序,最快O(n),最慢O(n2),平均O(1.3n-1.5n),不稳定
    public static void shellSort(int[] arr) {
        int[] dll = {5,3,1};
        for (int i = 0; i < dll.length; i++) {
            shell(arr, dll[i]);
        }
    }
    public static void shell(int[] arr,int gap) {
        int tmp = 0;
        for (int i = gap; i < arr.length; i++) {
            tmp = arr[i];
            int j;
            for (j = i-gap; j >= 0; j-=gap) {
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }

    //堆排序,最快O(n*logn),最慢O(n*logn),平均O(n*logn),不稳定
    public static void createBigHeap(int[] arr) {
        int len = arr.length;
        int parent = (len-2)/2;
        for (int i = parent; i >= 0; i--) {
            adjustDown(arr,i,len);
        }
    }
    public static void adjustDown(int[] arr,int parent,int len) {
        int child = parent*2+1;
        while (child < len) {
            if (child+1 < len && arr[child] < arr[child+1]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }
    public static void heapSort(int[] arr) {
        createBigHeap(arr);
        int end = arr.length-1;
        while (end > 0){
            int top = arr[0];
            arr[0] = arr[end];
            arr[end] = top;
            adjustDown(arr,0,end);
            end--;
        }
    }

    //快速排序

    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
//        selectSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        shellSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
