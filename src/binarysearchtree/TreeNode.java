
package binarysearchtree;

/**
 *
 * @author OMER
 */
public class TreeNode {
    int ID = 0;
    TreeNode right;
    TreeNode left;

    /**
     * Mission:Creation TreeNode object with getting ID as parameter.
     * @param ID 
     */ 
    public TreeNode(int ID) {
        this.ID = ID;
        right = null;
        left = null;
    }
}
