package solutions.java;

import java.util.PriorityQueue;

/**
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 */
public class FurthestBuilding {

    public static void main(String[] args){
        System.out.println(furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
    }

        public static int furthestBuilding(int[] heights, int bricks, int ladders) {
            //Ideally we should use ladders for the longest gaps bricks for remaining
            //We can have a ladder min heap based on no of ladders we have, and that would provide us with the smallest one
            //Which has to be covered with bricks if we continue to move forward, or we can do that with a insertion sort or
            // priority queue
            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
            int remainingBricks = bricks;
            if(heights.length == 1)
                return 1;
            int i=1;
            for(; i<heights.length; i++) {
                if(heights[i] > heights[i-1]) {
                    int diff = heights[i] - heights[i-1];
                    if(q.size() == ladders) {
                        int smallest = diff;
                        if(ladders != 0)
                            smallest = q.peek();
                        if(smallest < diff) {
                            q.poll();
                            q.add(diff);
                        } else {
                            smallest = diff;
                        }
                        if (remainingBricks >= smallest) {
                            remainingBricks -= smallest;
                        } else {
                            break;
                        }
                    } else {
                        q.add(diff);
                    }
                }
            }
            return --i;
        }
}
