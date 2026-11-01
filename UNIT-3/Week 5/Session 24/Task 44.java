import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    public void dfs(TreeNode root, int targetSum,
                    List<Integer> path,
                    List<List<Integer>> result) {

        
        if (root == null) {
            return;
        }

        
        path.add(root.val);

        
        if (root.left == null && root.right == null
                && targetSum == root.val) {

            result.add(new ArrayList<>(path));
        }

        
        dfs(root.left, targetSum - root.val, path, result);

        
        dfs(root.right, targetSum - root.val, path, result);

        
        path.remove(path.size() - 1);
    }
}
