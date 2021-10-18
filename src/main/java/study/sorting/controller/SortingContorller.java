package study.sorting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.sorting.service.SortingService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SortingContorller {

    private final SortingService sortingService;

    @GetMapping("/v1/sorting/{type}")
    public int[] sorting(@PathVariable("type") String type, @RequestParam(value="values") int[] values) {

        int[] arr = values;

        switch (type) {
            case "merge":
                sortingService.myMergeSort(arr);
                break;
            case "quick":
                sortingService.myQuickSort(arr);
                break;
            case "heap" :
                sortingService.myHeapSort(arr);
                break;
        }

        return arr;
    }

}
