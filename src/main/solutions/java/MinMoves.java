package solutions.java;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Given a non-empty integer array, 
 * 
 * Find the minimum number of moves required to make all array elements equal, 
 * Where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 */
public class MinMoves {

    public static void main(String args[]){
        System.out.println(minMoves2(new int[]{1,2,3}));
    }

    public static int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int mid = 0;

        if(nums.length%2 != 0)
            mid = nums[nums.length/2];
        else
            mid = (nums[nums.length/2] + nums[(nums.length/2)-1]) / 2;

        int moves = 0;

        for(int i=0; i< nums.length; i++){
            moves += Math.abs(mid  - nums[i]);
        }

        return moves;
    }


}
