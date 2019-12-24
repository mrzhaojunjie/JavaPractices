package 数据结构作业;

public class work4 {

    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //
    //本题中，一棵高度平衡二叉树定义为：
    //
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    public int getHigh(TreeNode root){
        return root==null?0:Math.max(getHigh(root.left),getHigh(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.abs(left-right)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    //给定一个二叉树，检查它是否是镜像对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的
    public boolean fun(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val
                &&fun(left.left,right.right)
                &&fun(left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return fun(root.left,root.right);
    }
}
