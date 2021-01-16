import jdk.nashorn.api.tree.Tree;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(){
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    TreeNode(int data){
        this.left = null;
        this.right = null;
        this.parent = null;
        this.data = data;
    }
}