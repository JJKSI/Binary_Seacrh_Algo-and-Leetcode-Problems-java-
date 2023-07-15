public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-12, -8, -2, 0, 2, 4, 5, 6, 7, 8, 9, 10};
        int search = 7;
        int ans = binary_search(arr, search);
        System.out.println(ans);
    }

    static int binary_search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
