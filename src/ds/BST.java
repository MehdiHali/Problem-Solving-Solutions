package ds;

public class BST extends BinaryTree {

    BST left;
    BST right;

    public BST(int data){
        super(data);
    }

    public BST insert(BST node){
        if(node.data < data){
            if(left == null) left = node;
            else left.insert(node);
        }

        else if(node.data > data){
            if(right == null) right =node;
            else right.insert(node);
        }
        return node;
    }

    public static boolean isLeaf(BST tree){
        if(tree.left == null && tree.right == null) return true;
        return false;
    }

    public boolean find(int value){
        if(data == value) return true;
        if(isLeaf(this)) return false;
        if(value > data) return right.find(value); 
        else return left.find(value);
    }

    private static boolean checkBST(BinaryTree tree, int min, int max){
        if(tree==null) return true;
        if(tree.data < min || tree.data > max) return false;
        return checkBST(tree, min, tree.data) && checkBST(tree, tree.data, max);
    }
    public static boolean checkBST(BinaryTree tree){
        return checkBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public static void inOrderTraversal(BST tree){
        if(tree ==null) return; 
        inOrderTraversal(tree.left);
        System.out.print(" --> "+tree.data);
        inOrderTraversal(tree.right);
    }

    public static void preOrderTraversal(BST tree){
        if(tree == null) return;
        System.out.print(" --> "+tree.data);
        preOrderTraversal(tree.left);
        preOrderTraversal(tree.right);
    }

    public static void postOrderTraversal(BST tree){
        if(tree == null) return;
        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
        System.out.print(" --> "+tree.data);
    }

    public static void main(String[] args) {
        BST bst = new BST(5); 
        BST node1 = bst.insert(new BST(9));
        BST node2 = bst.insert(new BST(4));
        BST node3 = bst.insert(new BST(2));
        BST node4 = bst.insert(new BST(22));
        BST node5 = bst.insert(new BST(12));

        BST.inOrderTraversal(bst);
        System.out.println("");

        BST.preOrderTraversal(bst);
        System.out.println("");

        BST.postOrderTraversal(bst);
        System.out.println("");

        System.out.println("left: "+bst.left.data+" right: "+bst.right.data+" is leaf: "+BST.isLeaf(bst));
    }
}
