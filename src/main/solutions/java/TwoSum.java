package solutions.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15}, 9));
    }

    public static int[] twoSum(int[] nums, int target) {

        //Slowest O(n2) solution
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[] {i,j};
        //         }
        //     }
        // }

        //Extra SET memory, O(n) - two pass
        // Set<Integer> val = new HashSet<>();
        // for(int i=0; i<nums.length; i++) {
        //     int diff = target - nums[i];
        //     if(val.contains(diff)){
        //         int j = find(diff, nums);
        //         return new int[] {i,j};
        //     }
        //     val.add(nums[i]);
        // }

        // Extra MAP memory, O(n) - one pass
        Map<Integer, Integer> val = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(val.containsKey(diff)){
                int j = val.get(diff);
                return new int[] {i,j};
            }
            val.put(nums[i],i);
        }

        return new int[]{};
    }

    public static int find(int num, int[] nums){
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == num)
                return i;
        }
        return -1;
    }

}
