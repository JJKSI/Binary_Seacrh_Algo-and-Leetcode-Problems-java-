//852. Peak Index in a Mountain Array
//        An array arr a mountain if the following properties hold:
//
//        arr.length >= 3
//        There exists some i with 0 < i < arr.length - 1 such that:
//        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//        Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
//
//        You must solve it in O(log(arr.length)) time complexity.
//
//          Question is the find the highest i.e. peak number in mountain array.
//          Mountain array: [1,2,4,5,4,3,1]// first increasing then decreasing
//        Example 1:
//
//        Input: arr = [0,1,0]
//        Output: 1

public class Leetcode4 {
    public static void main(String[] args) {

        int[] arr={1,2,4,5,4,3,1};
        int ans= peakIndexInMountainArray(arr);
        System.out.println(ans);

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
}
