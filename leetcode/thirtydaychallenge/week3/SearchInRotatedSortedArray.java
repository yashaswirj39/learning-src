package leetcode.thirtydaychallenge.week3;

public class SearchInRotatedSortedArray {

    ///my solution partially correct
    /*public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) {
            return -1;
        }

        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid] && target >= nums[start]) {
                end = mid - 1;
            } else if (target <= nums[end]) {
                start = mid + 1;
            } else {
                return -1;
            }
        }
        return -1;
    }*/

    public static int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + (right - left)) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int midpoint = (left + (right - left)) / 2;
            if (nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {5, 1, 3};
        //int target = 3;
        int target = 0;
        //int target = 4;
        //int target = 5;
        //System.out.println(search(nums, target));
    }
}
