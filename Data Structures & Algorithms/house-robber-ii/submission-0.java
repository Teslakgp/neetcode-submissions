class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int firstRange = robLinear(nums, 0, n - 2);
        int secondRange = robLinear(nums, 1, n - 1);
        return Math.max(firstRange, secondRange);
    }

    private int robLinear(int[] nums, int a, int b){
        int length = b - a + 1;
        if(length == 1) return nums[a];

        int[] dp = new int[length];
        dp[0] = nums[a];
        dp[1] = Math.max(nums[a], nums[a + 1]);

        for(int i = 2; i < length; i ++){
            dp[i] = Math.max(dp[i - 2] + nums[a + i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
