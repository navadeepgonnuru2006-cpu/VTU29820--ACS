import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        dfs(root, "", result);

        return result;
    }

    public void dfs(TreeNode root, String path, List<String> result) {

        if (root == null) {
            return;
        }

        
        path += root.val;

    
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        
        if (root.left != null) {
            dfs(root.left, path + "->", result);
        }

        
        if (root.right != null) {
            dfs(root.right, path + "->", result);
        }
    }
}
