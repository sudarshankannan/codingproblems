class Tree{
    TreeNode head;
    //constructor
    Tree(){
        this.head = null;
    }
    Tree(TreeNode root){
        this.head = root;
    }
    //add a node
    void insert(int data){
        TreeNode nuNode = new TreeNode(data);
        //empty tree case
        if(this.head == null){
            this.head = nuNode;
            return;
        }
        //
        TreeNode p = this.head;
        while(p.left != null || p.right != null){
            if(p.data == data){
                return;
            }
            //less 
            else if(p.data>data){
                if(p.left==null && p.right==null){
                    p.left = nuNode;
                    return;
                }
                else if(p.left==null && p.right!=null){
                    p.left = nuNode;
                    return;
                }
                else{
                    p = p.left;
                }
            }
            //greater
            else if(p.data<data){
                if(p.left==null && p.right==null){
                    p.right = nuNode;
                    return;
                }
                else if(p.right==null && p.left!=null){
                    p.right = nuNode;
                    return;
                }
                else{
                    p = p.right;
                }
            }
        }
    }
    //delete a node
    //minimalBST
    TreeNode createMinimalBST(int array[]){
        return createMinimalBST(array,0,array.length-1);
    }
    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if(end < start){
            return null;
        }
        int mid = (start + end) /2;
        TreeNode n = new TreeNode(arr[mid]);
        
        return n;
    }
}