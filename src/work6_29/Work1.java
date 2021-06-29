package work6_29;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:归并排序
 * User: starry
 * Date: 2021 -06 -29
 * Time: 19:11
 */
public class Work1 {

    public void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmp = new int[high-low+1];
        int i = 0;
        while(s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            array[j+low] = tmp[j];
        }
    }

    public void mergeSortInternal(int[] array, int low, int high) {
        if(low >= high) return;
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        merge(array,low,mid,high);
    }

    public void mergeSort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        mergeSortInternal(array,low,high);
    }

    public static void main(String[] args) {
        int[] array = {8,4,5,7,1,3,6,2};
        Work1 work = new Work1();
        work.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
