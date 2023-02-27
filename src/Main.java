public class Main {
    public static void main(String[] args) {
        int[] q = new int[]{1, 2, 6, 4};

        System.out.println(twoSum(q, 10));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}