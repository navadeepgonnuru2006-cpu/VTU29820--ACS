import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();

        int r = 1;

        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

    
        int[] bit = new int[r];

        List<Integer> result = new ArrayList<>(
            Collections.nCopies(n, 0)
        );

        
        for (int i = n - 1; i >= 0; i--) {

            int index = rank.get(nums[i]);

            
            result.set(i, query(bit, index - 1));

            
            update(bit, index);
        }

        return result;
    }

    
    private void update(int[] bit, int index) {

        while (index < bit.length) {
            bit[index]++;
            index += index & -index;
        }
    }

    
    private int query(int[] bit, int index) {

        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }
}
