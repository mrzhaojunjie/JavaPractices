package 数据结构作业;

public class work3 {
    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    public boolean isSameTree(TreeNode p, TreeNode q) {  //判断两个树是否相同
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;

    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){  //如果s为空树则肯定不具有
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubtree(s.left,t)){return true;}  //向左子树递归若包含该树则返回true
        return isSubtree(s.right,t);//向右子树递归
    }
    //求二叉树的最大深度
    public int maxDepth(TreeNode root) {
        return root == null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
