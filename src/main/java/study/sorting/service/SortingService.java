package study.sorting.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    public void myMergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // 분할
    private void mergeSort(int[] arr, int left, int right) {
        if(left<right){
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }else{
            return;
        }
    }

    // 정복
    private void merge(int[] arr, int left, int mid, int right){
        List<Integer> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]){
                temp.add(k,arr[i]);
                k++;
                i++;
            } else {
                temp.add(k,arr[j]);
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp.add(k,arr[i]);
            k++;
            i++;
        }

        while (j <= right) {
            temp.add(k,arr[j]);
            k++;
            j++;
        }

        k--;
        while (k >= 0) {
            arr[left + k] = temp.get(k);
            k--;
        }
    }

    public void myQuickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {

        int index;

        if (left < right) {
            index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {

        int random = (int)(Math.random() * (right - left) + left);

        int temp = arr[random];
        arr[random] = arr[right];
        arr[right] = temp;

        int pivot = arr[right];
        int index = left;

        for (int i = left; i <right; i++) {
            if (arr[i] <= pivot) {
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }

        temp = arr[index];
        arr[index] = arr[right];
        arr[right] = temp;

        return index;
    }

    public void myHeapSort(int[] arr) {
    }

}
