package competitions.solutions;

import static java.lang.System.*;

/**
 * This problem was asked by Netflix.
 *
 * Given a sorted list of integers of length N, determine if an element x is in the list
 * without performing any multiplication, division, or bit-shift operations.
 *
 * Do this in O(log N) time.
 */
public class NoOp {

    public static void main(String args[]){

        int[] input = new int[]{1, 2, 3, 4, 5, 7};

        int target = 4;
        int index = -1;

        //Order of N solution, simple loop
        for(int i=0; i<input.length; i++)
            if (input[i] > target)
                break;
            else if (input[i] == target)
                index = i;


        out.println(index);

        //Binary Search without division op
        index = binarySearch(0, input.length, input, target);
        out.println(index);

        //TEST CASES
        //Search first element
        out.println( binarySearch(0, input.length, input, 1));

        //Search last element
        out.println( binarySearch(0, input.length, input, 7));

        //Search element less than first
        out.println( binarySearch(0, input.length, input, 0));

        //Search element greater than last
        out.println( binarySearch(0, input.length, input, 9));

        //Search element which is not present but between first and last
        out.println( binarySearch(0, input.length, input, 6));

    }

    private static int binarySearch(int low, int high, int[] input, int target) {
        if(low > high || low == input.length)
            return -1;

        int i = divideBy2(low + high);

        if  (input[i] == target)
                return i;
        else if (input[i] < target)
                return binarySearch(i + 1 , high, input, target);
        else
                return binarySearch(low, i - 1 , input, target);

    }

    private static int divideBy2(int num) {
        int res = 0;
        while(num > 1){
            num -= 2;
            res++;
        }
        return res;
    }

}
