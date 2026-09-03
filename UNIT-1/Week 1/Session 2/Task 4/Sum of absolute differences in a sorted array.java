class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int prefixSum = 0;
        
        for (int i = 0; i < n; i++) {
            
            int suffixSum = totalSum - prefixSum - nums[i];
            
            
            int leftCount = i;
            int rightCount = n - 1 - i;
            
            int leftTotal = (leftCount * nums[i]) - prefixSum;
            int rightTotal = suffixSum - (rightCount * nums[i]);
            
            result[i] = leftTotal + rightTotal;
            
            
            prefixSum += nums[i];
        }
        
        return result;
    }
}
