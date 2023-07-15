public class Ceiling {
    public static void main(String[] args) {
        int[] arr = {-12, -8, -2, 0, 2, 4, 5, 6, 7, 8, 9, 10,15};
        int search = 12;
        int ans = Ceiling_function(arr, search);
        System.out.println(ans);
    }
// Ceiling is the smallest number greater than equal to the target number
    static int Ceiling_function(int[] arr, int target) {

        if(target> arr.length-1){
            return -1;
        }

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
        return start;
    }
}
