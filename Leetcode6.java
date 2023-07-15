//33. Search in Rotated Sorted Array
//        There is an integer array nums sorted in ascending order (with distinct values).
//
//        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
//        such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
//        or -1 if it is not in nums.
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//
//
//        Example 1:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1

public class Leetcode6 {
    public static void main(String[] args) {

        int[] nums={4,5,6,7,0,1,2};
       // System.out.println(Pivot_element(nums));
       int target=5;
        System.out.println(search(nums,target));
    }


    static int search(int[] nums, int target) {

        int pivot=Pivot_element(nums);
        if(pivot==-1){// if no pivot element do binary search
            return binary_search(nums,target);
        }
        // If pivot is found you have found two asc array
        //We will have cases to find the target
        if (nums[pivot]==target){
            return pivot;
        }
        if(target>nums[0]){
            return BBinary_search(nums,target,0,pivot-1);
        }

        return BBinary_search(nums,target,pivot+1, nums.length-1);


    }

    static int binary_search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
    static int Pivot_element(int[] nums) {

        int start= 0;
        int end= nums.length-1;

        while(start<end){
            int middle=start+(end-start)/2;

            // Four cases to find pivot(largest) element inside the array
            if(middle<end && nums[middle]>nums[middle+1]){
                return middle;
            }
            if(middle>start && nums[middle]<nums[middle-1]){
                return middle-1;
            }
            if(nums[middle] <= nums[start]){
                end =middle-1;
            }else {
                start= middle+1;
            }

        }
        return -1;
    }

    static int BBinary_search(int[] nums, int target , int start, int end) {
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;


    }

}
