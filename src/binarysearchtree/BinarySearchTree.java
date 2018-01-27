package binarysearchtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author OMER
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bst = treeCreator();

        bst.inorder(bst.root);
        bst.root = bst.deleteNode(bst.root, 24);
        System.out.println();
        bst.inorder(bst.root);

        bst.root = bst.deleteNode(bst.root, 4);
        System.out.println();
        bst.inorder(bst.root);
    }

    /**
     * Mission: This method reads input file and create tree using input data.
     * @return returns Binary S. Tree as BST type
     */
    public static BST treeCreator() {
        BST bst = new BST();
        try {
            FileReader fileReader = new FileReader("data/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String item;
            while ((item = bufferedReader.readLine()) != null) {
                int ID = Integer.parseInt(item);
                bst.insert(ID, bst.root);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return bst;
    }
}
