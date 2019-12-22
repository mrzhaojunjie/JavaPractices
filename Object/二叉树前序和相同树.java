package 数据结构作业;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class work2 {
    //给定一个二叉树，返回它的 前序 遍历。
        public void _preorderTraversal(TreeNode root, List<Integer> list){
            if(root!=null){
                list.add(root.val);
                _preorderTraversal(root.left,list);
                _preorderTraversal(root.right,list);
            }

        }
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            _preorderTraversal(root,list);
            return list;
        }
 //给定两个二叉树，编写一个函数来检验它们是否相同。
    //
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
        public boolean isSameTree(TreeNode p, TreeNode q) {
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

}
