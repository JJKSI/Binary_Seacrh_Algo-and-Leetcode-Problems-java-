import java.util.Arrays;

//
//34. Find First and Last Position of Element in Sorted Array
//        Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//        If target is not found in the array, return [-1, -1].
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
public class Leetcode2 {
    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int search = 8;
        int[] ans = searchRange(nums, search);
        System.out.println(Arrays.toString(ans));

    }

    static int[] searchRange(int[] nums, int target) {

        int[] ans={-1,-1};

        int startvalue = search(nums,target,true);
        int endvalue = search(nums,target,false);

        ans[0]=startvalue;
        ans[1]=endvalue;


       return ans;

    }

    //the below function returns index of the target value
    static int search(int[] nums, int target, boolean findstartindex){
        //potential answer
        int ans=-1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else {

                // Potential answer
                ans=middle;

                if(findstartindex){             //if(findstartindex ==  true)
                    end = middle - 1;
                }else {
                    start=middle+1;
                }
            }
        }
        return ans;

    }
}
