class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = 2147483647;
        int second = 2147483647;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) {
                first = nums[i];
            } else if(nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}