//Find position of an element in a sorted array of infinite numbers
//        Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
//        Source: Amazon Interview Experience.
//        Since array is sorted, the first thing clicks into mind is binary sssssearch, but the problem here is that we don’t know size of array.
//        If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key, first we find bounds and then apply binary search algorithm.
//        Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
//        ->if it is greater than high index element then copy high index in low index and double the high index.
//        ->if it is smaller, then apply binary search on high and low indices found.

// we can say binary search without using arr.length function
public class Leetcode3 {
    public static void main(String[] args) {

        int[] arr={2,3,4,5,89,163,233,445};
        int target= 89;
        int ans= Answer(arr,target);
        System.out.println(ans);




    }

    static int Answer(int[] arr, int target){
        // we have to find range here
        // start with the chunk of size 2

        int start=0;
        int end=1;

        // condition to find the target in the range

        while(target>arr[end]){
            int new_start= end+1;
            // new end == previous end + double the siz of chunk
            end= end + (end - start + 1)*2;//here we wanted to use old start so we didn't changed it here

            start=new_start;

        }
        return  Search( arr, target,start, end);

    }

    static int Search(int[] arr, int target, int start, int end){

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
