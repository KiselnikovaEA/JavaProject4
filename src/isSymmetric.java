import java.util.ArrayDeque;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        ArrayDeque<TreeNode> left = new ArrayDeque<>();
        ArrayDeque<TreeNode> right = new ArrayDeque<>();

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        if (root.left.val == root.right.val) {
            left.push(root.left);
            right.push(root.right);
        } else {
            return false;
        }

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode curLeft = left.pop();
            TreeNode curRight = right.pop();

            if (curLeft.val != curRight.val) {
                return false;
            }

            if (curLeft.left != null && curRight.right != null) {
                left.push(curLeft.left);
                right.push(curRight.right);
            }

            if (curLeft.left == null ^ curRight.right == null) {
                return false;
            }

            if (curLeft.right != null && curRight.left != null) {
                left.push(curLeft.right);
                right.push(curRight.left);
            }

            if (curLeft.right == null ^ curRight.left == null) {
                return false;
            }
        }

        return true;
    }
}
