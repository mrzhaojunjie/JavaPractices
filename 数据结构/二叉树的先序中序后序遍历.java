package 二叉树;

public class BinaryTree {
    private static int size;
    private static int leafSize;
    private Node root = null;
    //先序遍历：根  左子树 右子树
    public void preOrder(Node root){
        //终止条件：空树
        if(root == null){
            return;
        }
        else{
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

    }
    public void inOrder(Node root){
        if(root!=null){
            //访问左子树
            inOrder(root.left);
            System.out.print(root.val);
            inOrder(root.right);
        }
    }
    public void lastOrder(Node root){
        if(root!=null){
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.print(root.val);
        }
    }
    public void getSize1(Node root){
        if(root!=null){
            getSize1(root.left);
            getSize1(root.right);
            size++;
        }

    }

    public static int getSize2(Node root) {
        if(root == null){
            return 0;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }
    public void getLeafSize1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null&&root.right == null){
            ++leafSize;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);

    }
    public int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null&&root.left == null) {
            return 1;
        }
            return getLeafSize2(root.left)+getLeafSize2(root.right);
    }
    public int getKSize(Node root,int k){
        if(root == null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKSize(root.left,k-1)+getKSize(root.right,k-1);
    }

    public Node buildTree(){
        Node root = new Node('A');
        Node node1 = new Node('B');
        Node node2 = new Node('C');
        Node node3 = new Node('D');
        Node node4 = new Node('E');
        Node node5 = new Node('F');
        Node node6 = new Node('G');
        Node node7 = new Node('H');
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node6;
        node2.left = node5;
        node4.right = node7;
        return root;

    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        Node root = bTree.buildTree();
        bTree.preOrder(root);
        System.out.println();
        bTree.inOrder(root);
        System.out.println();
        bTree.lastOrder(root);
        System.out.println();
        bTree.getSize1(root);
        System.out.println(bTree.size);
        System.out.println(bTree.getLeafSize2(root));
    }
}
