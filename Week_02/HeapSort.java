import java.util.Arrays;

public class HeapSort {

    public void sort(int[] arr) {
        //构建大顶堆
        int length = arr.length;
        for(int i = (length >>> 1) - 1; i >= 0; i--)
            shiftDown(arr, length, i);

        //提出最大值，并对剩余数据重新构建
        for(int i = length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            shiftDown(arr, i, 0);
        }
    }

    private void shiftDown(int[] arr, int length, int index) {
        int half = length >>> 1;
        int val = arr[index];
        while(index < half) {
            int left = (index << 1) + 1;
            int right = left + 1;
            int temp = arr[left];

            //递增
            /*if(right < length && arr[left] < arr[right])
                temp = arr[left = right];
            if(val >= temp)
                break;*/

            //递减
            if(right < length && arr[left] > arr[right])
                temp = arr[left = right];
            if(val <= temp)
                break;
            arr[index] = temp;
            index = left;
        }
        arr[index] = val;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,26,25,19,17,1,90,3,36};
        HeapSort sort = new HeapSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
