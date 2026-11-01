import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(
                (long) nums1[a[0]] + nums2[a[1]],
                (long) nums1[b[0]] + nums2[b[1]]
            )
        );

    
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{i, 0});
        }

        
        while (k > 0 && !pq.isEmpty()) {

            int[] curr = pq.poll();

            int i = curr[0];
            int j = curr[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

        
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }

            k--;
        }

        return result;
    }
}
