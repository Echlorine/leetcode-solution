class LockingTree {

    class TreeNode {

        List<TreeNode> children; // 所有的孩子结点
        int val; // 标记上锁用户，若为0，代表没有被上锁

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    private Map<Integer, TreeNode> map = new HashMap<>();
    private int[] parent;
    public LockingTree(int[] parent) {
        // 创建树，初始状态下，所有结点都没有上锁
        for (int i = 0; i < parent.length; i++) {
            TreeNode t = new TreeNode(0); //
            t.children = new LinkedList<>();
            map.put(i, t);
        }
        // 编辑父子关系
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) continue;
            TreeNode t = map.get(i);
            TreeNode p = map.get(parent[i]);
            p.children.add(t);
        }
        this.parent = parent;
    }
    
    public boolean lock(int num, int user) {
        TreeNode p = map.get(num);
        if (p.val != 0) return false;
        p.val = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        TreeNode p = map.get(num);
        if (p.val != user) return false;
        p.val = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        TreeNode p = map.get(num);
        if (p.val != 0) return false;
        if (!isParentLock(num)) return false;
        if (!isChildLock(p)) return false;
        p.val = user;
        return true;
    }

    private boolean isChildLock(TreeNode root) {
        // 递归出口
        if (root == null) return false;
        boolean res = false;
        for (TreeNode child : root.children) {
            res |= isChildLock(child);
            child.val = 0;
        }
        return res || root.val > 0;
    }

    private boolean isParentLock(int num) {
        int p = parent[num];
        while (p != -1) {
            if (map.get(p).val > 0) return false;
            p = parent[p];
        }
        return true;
    }

    private void changeLock(TreeNode root) {
        // 递归出口
        if (root == null) return;
        for (TreeNode child : root.children) {
            changeLock(child);
        }
        root.val = 0;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */