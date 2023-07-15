//1095. Find in Mountain Array
//        This problem is an interactive problem.)
//
//        You may recall that an array arr is a mountain array if and only if:
//
//        arr.length >= 3
//        There exists some i with 0 < i < arr.length - 1 such that:
//        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//        Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
//        If such an index does not exist, return -1.
//
//        You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
//
//        MountainArray.get(k) returns the element of the array at index k (0-indexed).
//        MountainArray.length() returns the length of the array.
//        Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
//        Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//
//
//        Example 1:
//
//        Input: array = [1,2,3,4,5,3,1], target = 3
//        Output: 2
//        Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
public class Leetcode5 {
    public static void main(String[] args) {

        int[] arr={1,2,4,5,4,3,1};
        int target=4;

        int ans= search(arr,target);
        System.out.println(ans);


    }

    static int search(int[] arr, int target){

        int peak=peakIndexInMountainArray(arr);
        int firsttry= orderagnosticbinarysearch(arr,target,0,peak);
        if(firsttry!=-1){
            return firsttry;
        }
        return  orderagnosticbinarysearch(arr,target,peak,arr.length-1);
    }

    static int peakIndexInMountainArray(int[] arr) {

        int start=0;
        int end= arr.length -1;

        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                //WE are in decreasing side of the array so it may be the answer or look at the left side for answer
                end=mid;//
            }else{
                // we are in increasing part of the array
                start=mid+1;
                //beacuse middle +1 is greater than the middle element
            }
        }
        // in the end the start and end element will point at the same element that will the largest number and that will
        // the answer (START == END)
        return start;// or return end both of tyhem are same
    }

    static int orderagnosticbinarysearch(int[] arr, int target , int start, int end) {

        //array sorted in asc or desc

        boolean isAsc;
        isAsc = arr[start] < arr[end];


        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target == arr[middle]) {
                return middle;
            }

            if (isAsc) {
                if (target < arr[middle]) {
                    end = middle - 1;
                } else if (target > arr[middle]) {
                    start = middle + 1;
                }
            } else {
                if (target > arr[middle]) {
                    end = middle - 1;
                } else if (target < arr[middle]) {
                    start = middle + 1;
                }
            }

        }
        return -1;
    }






}
