//Find the Rotation Count in Rotated Sorted array
//        Given an array arr[] of size N having distinct numbers sorted in increasing order and
//        the array has been right rotated (i.e, the last element will be cyclically shifted to the starting position of the array) k number of times, the task is to find the value of k.
//
//        Examples:
//
//        Input: arr[] = {15, 18, 2, 3, 6, 12}
//        Output: 2
//        Explanation: Initial array must be {2, 3, 6, 12, 15, 18}.
//        We get the given array after rotating the initial array twice.
//
//        Input: arr[] = {7, 9, 11, 12, 5}
//        Output: 4


public class Leetcode7 {

    public static void main(String[] args) {

        int[] arr= {15,18,2,3,6,12};
        System.out.println(count_roatation(arr));

    }

    static int count_roatation(int[] arr){
        int pivot=pivot_element(arr);

        return pivot+1;
    }

    static int pivot_element(int[] arr){
        int start= 0;
        int end = arr.length- 1;

        //The four cases to check the pivot element

        while(start<end){
            int middle= start + (end-start)/2;

            if(arr[middle]> arr[middle+1]){
                return  middle;
            }

            if(arr[middle]<arr[middle-1]){
                return middle-1;
            }

            if(arr[middle]<=arr[start]){
                end=middle-1;
            }else{
                start=middle+1;
            }

        }
        return -1;
    }


}
