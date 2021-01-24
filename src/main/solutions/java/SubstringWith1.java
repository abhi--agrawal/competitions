package solutions.java;

/**
 * Given a binary string s (a string consisting only of '0' and '1's).
 *
 * Return the number of substrings with all characters 1's.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 *
 * Input: s = "0110111"
 * Output: 9
 * Explanation: There are 9 substring in total with only 1's characters.
 * "1" -> 5 times.
 * "11" -> 3 times.
 * "111" -> 1 time.
 * Example 2:
 *
 * Input: s = "101"
 * Output: 2
 * Explanation: Substring "1" is shown 2 times in s.
 * Example 3:
 *
 * Input: s = "111111"
 * Output: 21
 * Explanation: Each substring contains only 1's characters.
 * Example 4:
 *
 * Input: s = "000"
 * Output: 0
 */
public class SubstringWith1 {

    private static final int MODULO = 1000000007;

    public static void main(String[] args) {
        System.out.println(numSub("111111"));
    }

    public static int numSub(String s) {
        int count = 0;
        int cur = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                count += ++cur;
                count %= MODULO;
            } else {
                cur = 0;
            }
        }
        return count;
    }

}
