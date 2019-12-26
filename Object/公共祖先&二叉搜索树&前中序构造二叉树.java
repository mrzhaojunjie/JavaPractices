package 数据结构作业;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

import java.util.Stack;

public class work {
/*    public boolean find(TreeNode root,TreeNode node){  //在左右子树中先找节点node
        if(root == null)
            return false;
        if(root == node)
            return true;
        if(find(root.left,node))
            return true;
        return find(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //某一节点为根节点  则肯定是公共祖先节点
        boolean PL,PR,QL,QR;
        if(root == p ||root == q){
            return root;
        }
        //同一边
        if(find(root.left,p)){   //在左子树中找p节点 找到则为真
            PL = true;
            PR = false;
        }else{
            PL = false;
            PR = true;
        }
        if(find(root.left,q)){   //在左子数中找q
            QL = true;
            QR = false;
        }else{
            QL = false;
            QR = true;
        }
        if(PL&&QL){   //遍历路径相同继续进行遍历   路径不同  则返回其根节点；
            return lowestCommonAncestor(root.left,p,q);
        }
        if(PR&&QR){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;  //返回其根节点即为公共祖先节点
    }*/



    //递归栈做法

    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> st){
        if(root == null){
            return false;
        }
        st.push(root);
        if(root == node)//结束
            return true;

        //判断左右子树是否存在node
        if(getPath(root.left,node,st)){
            return true;
        }
        if(getPath(root.right,node,st)){
            return true;
        }
        st.pop();
        return false;

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        getPath(root,p,path1);
        getPath(root,q,path2);
        while(path1.size()!=path2.size()){
            if(path1.size() > path2.size()){
                path1.pop();
            }else{
                path2.pop();
            }
        }
        while(path1.size()!=0){
            if(path1.peek() == path2.peek()){
                break;
            }else{
                path1.pop();
                path2.pop();
            }
        }
        return path1.peek();
    }

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

    static TreeNode prev = null;
    public void _Convert(TreeNode root){
        if(root == null)
            return;
        //中序遍历
        _Convert(root.left);//遍历左子树
        //处理当前节点
        root.left = prev;
        if(prev!=null)
            prev.right = root;
        prev = root; // prev置为根节点
        _Convert(root.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        prev = null; //完成一个子树重置prev因为左右两棵树不关联
        _Convert(pRootOfTree);
        while(pRootOfTree.left!=null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }


//据一棵树的前序遍历与中序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
    static int curIdx = 0;
    public  TreeNode _buildTree(int[] pre,int[] in,int inS,int inE){
        if(inS>inE){  //空树
            return null;
        }
        int rootValue = pre[curIdx];
        curIdx++;
        TreeNode root = new TreeNode(rootValue);
        //区间除过根节点 ，当中没有孩子结点
        if(inS == inE){
            return root;
        }
        //确定左右子树的区间
        int i;
        for(i = inS;i<=inE;++i){
            if(in[i] == rootValue)
                break;
        }
        //左右子树的区间：
        //左子树： [inS,i-1] 右子树：[i+1,inE]

        //构建左右子树
        root.left = _buildTree(pre,in,inS,i-1);
        root.right = _buildTree(pre,in,i+1,inE);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIdx = 0;
        return _buildTree(preorder,inorder,0,preorder.length-1);
    }
}
