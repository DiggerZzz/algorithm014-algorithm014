import java.util.Arrays;

public class Sort {

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i ++) {
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    public static void selectionSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < nums.length; j++) {
                min = nums[j] < nums[min] ? j : min;
            }
            swap(nums, i, min);
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    /**
     * 归并排序
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        mergeSortRecursive(nums, 0, nums.length - 1);
    }

    private static void mergeSortRecursive(int[] nums, int start, int end) {
        if(start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSortRecursive(nums, start, mid);
        mergeSortRecursive(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int pt = 0, p1 = start, p2 = mid + 1;
        //开始合并，存在temp中
        while(p1 <= mid && p2 <= end) {
            if(nums[p1] <= nums[p2]) {
                temp[pt++] = nums[p1++];
            } else {
                temp[pt++] = nums[p2++];
            }
        }

        //收尾，如果哪边有剩余的，直接加到temp中
        while(p1 <= mid) temp[pt++] = nums[p1++];
        while(p2 <= end) temp[pt++] = nums[p2++];

        //将temp复制到原数组中
        for(int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

    public static void quickSort(int[] nums) {
        quickSortRecursive(nums, 0, nums.length - 1);
    }

    private static void quickSortRecursive(int[] nums, int start, int end) {
        if(start >= end)
            return;
        int pivotIndex = partition(nums, start, end);
        quickSortRecursive(nums, start, pivotIndex - 1);
        quickSortRecursive(nums, pivotIndex + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while(start < end) {
            while(start < end && nums[end] >= pivot)
                end--;
            nums[start] = nums[end];

            while(start < end && nums[start] <= pivot)
                start++;
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }


    /**
     * 两两交换
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
//        Sort.bubbleSort(nums);
//        Sort.selectionSort(nums);
//        Sort.insertionSort(nums);
//        Sort.mergeSort(nums);
        Sort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
