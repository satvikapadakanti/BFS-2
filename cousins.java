class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Check if x and y are siblings (i.e., same parent)
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                        (curr.left.val == y && curr.right.val == x)) {
                        return false; // same parent, not cousins
                    }
                }

                // Mark if x or y is found at this level
                if (curr.left != null) {
                    q.add(curr.left);
                    if (curr.left.val == x) x_found = true;
                    if (curr.left.val == y) y_found = true;
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    if (curr.right.val == x) x_found = true;
                    if (curr.right.val == y) y_found = true;
                }
            }

            // If both are found at the same level and not siblings
            if (x_found && y_found) return true;

            // If only one is found at this level, they can't be cousins
            if (x_found || y_found) return false;
        }

        return false; // If we never find both
    }
}
