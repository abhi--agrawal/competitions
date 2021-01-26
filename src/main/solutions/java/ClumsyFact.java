package solutions.java;

/**
 * For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.
 * However, these operations are still applied using the usual order of operations of arithmetic:
 * we do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.
 *
 * Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.  This guarantees the result is an integer.
 *
 * Implement the clumsy function as defined above: given an integer N, it returns the clumsy factorial of N.
 */
public class ClumsyFact {


    //Better solution
    // https://leetcode.com/problems/clumsy-factorial/discuss/252279/You-never-think-of-this-amazing-O(1)-solution

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int N) {
        int res = -1;
        if(N <= 1) {
            return N;
        }
        int i = N;
        while(i > 0) {
            int cur = i;
            if (i > 1) {
                cur *= i-1;
            }
            if (i > 2) {
                cur = (int)Math.floor(cur / (i-2));
            }
            if(res == -1) {
                res = cur;
            } else {
                res -= cur;
            }
            if(i > 3) {
                res += i-3;
            }
            i -= 4;
        }
        return res;
    }
}
