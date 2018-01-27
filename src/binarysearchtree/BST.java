
package binarysearchtree;

/**
 *
 * @author OMER
 */
public class BST {

    /**
     * This variable is root of the tree.
     */
    public TreeNode root;


    public BST() {
        root = null;
    }
    
    /**
     * Difficulties: How makes decision for Creating and insert a new node. <br>
     * Solution: If ID of current node bigger than the data, this data will be added left side of the current node.
     * else this data will be added right side of the current node.
     * @param data value of new node which is will be added
     * @param currentNode is start from root and reaches leaf according to data
     * @return returns TreeNode type
     */
    public TreeNode insert(int data, TreeNode currentNode) {
        if (root == null) {
            root = new TreeNode(data);

            currentNode = root;
        }

        if (currentNode == null) {
            currentNode = new TreeNode(data);

        } else if (currentNode.ID > data) {
            currentNode.left = insert(data, currentNode.left);
        } else if (currentNode.ID < data) {
            currentNode.right = insert(data, currentNode.right);
        }

        return currentNode;
    }
    
    /**
     * Searches item depends on ID.
     * @param ID searched information 
     * @param currentNode started from root and replaced depending on the ID
     */
    public void searchKey(int ID, TreeNode currentNode) {
        if (ID > currentNode.ID) {
            if (currentNode.right != null) {
                searchKey(ID, currentNode.right);
            } else {
                System.out.println(ID + " is not exist");
            }
        } else if (ID < currentNode.ID) {
            if (currentNode.left != null) {
                searchKey(ID, currentNode.left);
            } else {
                System.out.println(ID + " is not exist");
            }
        } else if (ID == currentNode.ID) {
            System.out.println(ID + " is found in ");
        }
    }

    /**
     * The left subtree is visited first, then the root and later the right sub-tree. <br>
     * The output will produce sorted key values in an ascending order.
     * @param root 
     */
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.ID + " ");
            inorder(root.right);

        }
    }
    
    /**
     * The root node is visited last. <br>
     * First it traverse the left subtree, then the right subtree and finally the root node.
     * @param root 
     */
    public void postorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.ID + " ");

        }
    }
    
    /**
     * The root node is visited first, then the left subtree and finally the right subtree.
     * @param root 
     */
    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.ID + " ");
            inorder(root.left);
            inorder(root.right);

        }
    }

    /**
     * Mission: Delete item depends on ID. <br>
     * Difficulties: one of four different situations will arise during the tree node we want to delete. <br>
     * These situations; <br>
     *  1-) this node can be leaf  <br>
     *  2-) this node may have right and left subtrees  <br>
     *  3-) this node may not have a left lower leaf while having a right lower leaf  <br>
     *  4-) this node may not have the right lower sub-tree when it has the left sub-tree.  <br>
     * @param currentNode started from root goes to node to be deleted
     * @param ID to be deleted
     * @return TreeNode
     */
    public  TreeNode deleteNode(TreeNode currentNode, int ID) {
        
        if (currentNode == null) {
            return null;
        }
        if (currentNode.ID > ID) {
            currentNode.left = deleteNode(currentNode.left, ID);
        } 
        else if (currentNode.ID < ID) {
            currentNode.right = deleteNode(currentNode.right, ID);

        } 
        else {
            // if nodeToBeDeleted have both side children
            if (currentNode.left != null && currentNode.right != null) {
                TreeNode temp = currentNode;
                // Find maximum element from left
                TreeNode maxNodeForRight = getMaximumID(temp.left);
                // Replacing current node with maximum node from left subtree
                currentNode.ID = maxNodeForRight.ID;
                
                // Deleting maximum node from left
                currentNode.left=deleteNode(currentNode.left, maxNodeForRight.ID);

            } 
            else if (currentNode.left == null && currentNode.right == null) {
                currentNode = null;
            }

            // if currentNode has only left child
            else if (currentNode.left != null) {
                currentNode = currentNode.left;
            } // if currentNode has only right child
            else if (currentNode.right != null) {
                currentNode = currentNode.right;
            } 
        }
        return currentNode;
    }

    /**
     * Mission: This method gets maximum value by going to the far right of the tree
     * @param treeNode keeps information of three
     * @return 
     */
    public TreeNode getMaximumID(TreeNode treeNode) {
        if (treeNode.right == null) {
            return treeNode;
        }
        return getMaximumID(treeNode.right);
    }

}
