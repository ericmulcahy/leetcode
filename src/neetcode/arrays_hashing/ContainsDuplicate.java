package neetcode.arrays_hashing;

// https://leetcode.com/problems/contains-duplicate/
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {
    
    public static void main(String[] args) {
        boolean result;
        int[] nums = {1,2,3,1};
        result = containsDuplicate(nums);
        System.out.println("{1,2,3,1}  --> " + result);

        int[] nums2 = {1,2,3,4};
        result = containsDuplicate(nums2);
        System.out.println("{1,2,3,4}  --> " + result);

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        result = containsDuplicate(nums3);
        System.out.println("{1,1,1,3,3,4,3,2,4,2}  --> " + result);        
    }

    
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
