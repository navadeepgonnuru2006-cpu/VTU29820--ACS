import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        
        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();

        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {

            Object[] data = queue.poll();

            TreeNode node = (TreeNode) data[0];
            int row = (int) data[1];
            int col = (int) data[2];

            
            map.putIfAbsent(col, new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return a[0] - b[0];
                    }
                    return a[1] - b[1];
                }
            ));

            
            map.get(col).offer(new int[]{row, node.val});

            
            if (node.left != null) {
                queue.offer(new Object[]{node.left, row + 1, col - 1});
            }

            
            if (node.right != null) {
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();

        for (PriorityQueue<int[]> pq : map.values()) {

            List<Integer> column = new ArrayList<>();

            while (!pq.isEmpty()) {
                column.add(pq.poll()[1]);
            }

            result.add(column);
        }

        return result;
    }
}
