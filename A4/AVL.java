package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author your name here
 * @author David Brown
 * @version 2023-09-06
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

    /**
     * Returns the balance item of node. If greater than 1, then left heavy, if less
     * than -1, then right heavy. If in the range -1 to 1 inclusive, the node is
     * balanced. Used to determine whether to rotate a node upon insertion.
     *
     * @param node The TreeNode to analyze for balance.
     * @return A balance number.
     */
    private int balance(final TreeNode<T> node) {
    	if (node == null || (node.getRight() == null && node.getLeft() == null)) {
    		return 0;
    	}
    	
    	if (node.getLeft() == null) {
    		return 0 - node.getHeight(); 
    	}
    	
    	if (node.getRight() == null) {
    		return node.getHeight();
    	}
    	
    	return node.getLeft().getHeight() - node.getRight().getHeight();
        }


    /**
     * Rebalances the current node if its children are not balanced.
     *
     * @param node the node to rebalance
     * @return replacement for the rebalanced node
     */
    private TreeNode<T> rebalance(TreeNode<T> node) {
    	balance(node);
    	return node;
    }

    /**
     * Performs a left rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> node) {
    	TreeNode<T> rightNode = node.getRight();
    	TreeNode<T> centerNode = rightNode.getLeft();
    	
    	rightNode.setLeft(node);
    	node.setRight(centerNode);
    	node.updateHeight();
    	rightNode.updateHeight();
    	
    	return rightNode;
    }

    /**
     * Performs a right rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> node) {
    	TreeNode<T> leftNode = node.getLeft();
    	TreeNode<T> centerNode = leftNode.getRight();
    	
    	leftNode.setRight(node);
    	node.setLeft(centerNode);
    	node.updateHeight();
    	leftNode.updateHeight();
    	return leftNode;
    }

    /**
     * Auxiliary method for insert. Inserts data into this AVL.
     *
     * @param node The current node (TreeNode).
     * @param data Data to be inserted into the node.
     * @return The inserted node.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedItem<T> data) {
    	if (node == null) { //Add a new node containing data
    		TreeNode<T> new_node = new TreeNode<T>(data);
    		this.size++;
    		new_node.getdata().incrementCount();
    		return new_node;
    	}//if
    	
    	int pivot = node.getdata().compareTo(data), y;    
    	if (pivot == 0) {        
    		this.size++;        
    		node.getdata().incrementCount();        
    		return node;    
    		}//if statement
    	else if (pivot > 0) {        
    		node.setLeft(this.insertAux(node.getLeft(), data));        
    		node.updateHeight();        y = this.balance(node);        
    		if (y >= 2 && this.balance(node.getLeft()) >= 0) {        
    			node = this.rotateRight(node);
    		}// if statement
    		else if (y >= 2 && this.balance(node.getLeft()) <= -1) {        
    			node.setLeft(this.rotateLeft(node.getLeft()));        
    			node = this.rotateRight(node);        
    			}//else if statement 2   
    		this.size++;        
    		return node;
    		}//else if statement 1
    	else if (pivot < 0) {      
    		node.setRight(this.insertAux(node.getLeft(), data));        
    		node.updateHeight();        
    		y = this.balance(node);        
    		if (y <= -2 && this.balance(node.getRight()) <= 0) {        
    			node = this.rotateLeft(node);        
    			}// if statement
    		else if (y <= -2 && this.balance(node.getRight()) >= -1) {     
    			node.setRight(this.rotateRight(node.getRight()));        
    			node = this.rotateLeft(node);        
    			}// else if statement     
    		this.size++;        
    		return node;
    		}//else if statement 3
    	else {      
    		node = new TreeNode<T>(data);        
    		node.getdata().incrementCount();        
    		this.size++;        
    		return node;
    	}//else
    }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An AVL must meet the BST validation conditions, and additionally be
     * balanced in all its subtrees - i.e. the difference in height between any two
     * children must be no greater than 1.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {
    	if (node == null) {
    		return true;
    	}
    	else if (minNode != null) {
    		if (minNode.getdata().compareTo(node.getdata()) > 0 ) {
    			return false;
    		}
    	}
    	else if (maxNode != null) {
    		if (maxNode.getdata().compareTo(node.getdata()) < 0 ) {
    			return false;
    		}
    	}
    	return isValidAux(node.getLeft(), minNode, node) && isValidAux(node.getRight(), node, maxNode);
    }

    /**
     * Determines whether two AVLs are identical.
     *
     * @param target The AVL to compare this AVL against.
     * @return true if this AVL and target contain nodes that match in position,
     *         item, count, and height, false otherwise.
     */
    public boolean equals(final AVL<T> target) {
	return super.equals(target);
    }

}
