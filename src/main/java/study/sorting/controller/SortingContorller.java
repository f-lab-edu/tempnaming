package study.sorting.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class SortingContorller {

    @GetMapping("/v1/sorting/{type}")
    public int[] sorting(@PathVariable("type") String type, @RequestParam(value="values") int[] values) {

        int[] arr = values;

        switch (type) {
            case "merge":
                mergeSort(arr, 0, arr.length - 1);
            case "quick":
            case "heap" :
        }

        return arr;
    }

    private void merge(int[] arr, int left, int mid, int right){
//        List<Integer> temp = new ArrayList<>();
        int[] temp = new int[2000];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        k--;
        while (k >= 0) {
            arr[left + k] = temp[k];
            k--;
        }
    }

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

    private void quickSort(int[] arr) {
        return;
    }

    private void heapSort(int[] arr) {
        return;
    }
}
