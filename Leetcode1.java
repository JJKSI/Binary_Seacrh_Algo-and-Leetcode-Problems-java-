//744. Find Smallest Letter Greater Than Target
//You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
// There are at least two different characters in letters.
//
// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
//
//
//
//        Example 1:
//
//        Input: letters = ["c","f","j"], target = "a"
//        Output: "c"
//        Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.


public class Leetcode1 {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char search = 'a';
        char ans = (char) Ceiling_function(arr, search);
        System.out.println(ans);

    }

    static int Ceiling_function(char[] arr, char target) {

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
            }
        }
        return arr[start%arr.length];
    }
}
