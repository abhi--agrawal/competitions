package solutions.java;

import java.util.*;

public class KEqualPartition {

    public static void main(String []args){
        int[] l = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(l, 4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for(int num : nums) {
            list.add(num);
            sum += num;
        }

        if(k==0 || sum % k != 0)
            return false;

        int subSum = sum/k;
        int i =0;
        while(i< list.size()) {
            if(list.get(i) == subSum || list.get(i) == 0) {
                int r = list.remove(i);
            } else {
                i++;
            }
        }
        return greedyDivide(list, subSum, 0, subSum);
    }

    public static boolean greedyDivide(List<Integer> list, int sum, int i, int originalSum) {
        if(list.isEmpty())
            return true;
        else {
            int cur = list.get(i);
            if(cur == sum){
                list.remove(i);
                return greedyDivide(new ArrayList(list), originalSum, 0, originalSum);
            } else {
                if (cur < sum) {
                    int newSum = sum - cur;
                    List<Integer> newList = new ArrayList(list);
                    newList.remove(i);
                    boolean temp = greedyDivide(newList, newSum, 0, originalSum);
                    if(temp) {
                        list = new ArrayList(newList);
                        i = 0;
                        sum = originalSum;
                    } else {
                        temp = greedyDivide(new ArrayList(list), sum, 1, originalSum);
                        if(temp) {
                            i = 0;
                            sum = originalSum;
                        } else {
                            return false;
                        }
                    }
                }
                System.out.println(list);
                return greedyDivide(new ArrayList(list), sum, i, originalSum);
            }
        }
    }
}
