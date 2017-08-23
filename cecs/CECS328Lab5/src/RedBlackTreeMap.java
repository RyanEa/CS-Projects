import java.util.*;

// A Map ADT structure using a red-black tree, where keys must implement
// Comparable.
public class RedBlackTreeMap<TKey extends Comparable<TKey>, TValue> {
	// A Node class.
	private class Node {
		private TKey mKey;
		private TValue mValue;
		private Node mParent;
		private Node mLeft;
		private Node mRight;
		private boolean mIsRed;
		public Node(TKey key, TValue data, boolean isRed) {
			mKey = key;
			mValue = data;
			mIsRed = isRed;
			mLeft = NIL_NODE;
			mRight = NIL_NODE;
		}
		
		@Override
		public String toString() {
			return "(" + mKey + ", " + mValue + ")" + (mIsRed ? " (Red) " : " (Black) ");
		}
	}

	private Node mRoot;
	private int mCount;



	// Rather than create a "blank" black Node for each NIL, we use one shared
	// node for all NIL leaves.
	private final Node NIL_NODE = new Node(null, null, false);

	//////////////////// I give you these utility functions for free.

	// Get the # of keys in the tree.
	public int getCount() {
		return mCount;
	}

	// Finds the value associated with the given key.
	public TValue find(TKey key) {
		Node n = bstFind(key, mRoot); // find the Node containing the key if any
		if (n == null || n == NIL_NODE)
			throw new RuntimeException("Key not found");
		return n.mValue;
	}


	/////////////////// You must finish the rest of these methods.

	// Inserts a key/value pair into the tree, updating the red/black balance
	// of nodes as necessary. Starts with a normal BST insert, then adjusts.
	public void insert(TKey key, TValue data) {
		Node n = new Node(key, data, true); // nodes start red

		// normal BST insert; n will be placed into its initial position.
		// returns false if an existing node was updated (no rebalancing needed)
		boolean insertedNew = bstInsert(n, mRoot);
		if (!insertedNew)
			return;
		// check cases 1-5 for balance violations.
		checkBalance(n);
	}

   // Applies rules 1-5 to check the balance of a tree with newly inserted
   // node n.
   private void checkBalance(Node n) {
       if (n == mRoot) {
           // case 1: new node is root.
           n.mIsRed = false;
       }
       // handle additional insert cases here.
       else if (!n.mParent.mIsRed) {
           return;
       } else if (n.mParent.mIsRed == getUncle(n).mIsRed) {
           n.mParent.mIsRed = false;
           getUncle(n).mIsRed = false;
           getGrandparent(n).mIsRed = true;
           checkBalance(getGrandparent(n));
       } else {
           if (getGrandparent(n).mLeft.mRight == n) {
               rotateLeft(n.mParent);
               n = n.mLeft;
           } else if (getGrandparent(n).mRight.mLeft == n) {
               rotateRight(n.mParent);
               n = n.mRight;
           }
           if (getGrandparent(n) != null && getGrandparent(n).mLeft.mLeft == n) {
               getGrandparent(n).mIsRed = !getGrandparent(n).mIsRed;
               n.mParent.mIsRed = !n.mParent.mIsRed;
               rotateRight(getGrandparent(n));
           } else if (getGrandparent(n) != null && getGrandparent(n).mRight.mRight == n) {
               getGrandparent(n).mIsRed = !getGrandparent(n).mIsRed;
               n.mParent.mIsRed = !n.mParent.mIsRed;
               rotateLeft(getGrandparent(n));
           }
       }
   }

	// Returns true if the given key is in the tree.
	public boolean containsKey(TKey key) {
		// TODO: using at most three lines of code, finish this method.
		// HINT: write the bstFind method first.
        if(bstFind(key,mRoot) != null)
            return true;
		return false;
	}

	// Prints a pre-order traversal of the tree's nodes, printing the key, value,
   // and color of each node.
	public void printStructure() {
        printStructure(mRoot);
      // TODO: a pre-order traversal. Will need recursion.
	}
	private void printStructure(Node n){
        if(n == NIL_NODE)
            return;
        System.out.println(n.toString());
        printStructure(n.mLeft);
        printStructure(n.mRight);
    }
	// Retuns the Node containing the given key. Recursive.
	private Node bstFind(TKey key, Node currentNode) {
		// TODO: write this method. Given a key to find and a node to start at,
		// proceed left/right from the current node until finding a node whose
		// key is equal to the given key.
        if(currentNode == null || currentNode == NIL_NODE){return currentNode;}
        int compare = key.compareTo(currentNode.mKey);
        if(compare == 0){
            return currentNode;}
        else if (compare < 0){
            return bstFind(key, currentNode.mLeft);}
        else{
            return bstFind(key, currentNode.mRight);}
	}


	//////////////// These functions are needed for insertion cases.

	// Gets the grandparent of n.
	private Node getGrandparent(Node n) {
		// TODO: return the grandparent of n
        if(n.mParent == null || n.mParent.mParent == null)
		    return null;
        return n.mParent.mParent;
	}

	// Gets the uncle (parent's sibling) of n.
	private Node getUncle(Node n) {
		// TODO: return the uncle of n
        if(getGrandparent(n) == null || getGrandparent(n) == null ||
                getGrandparent(n).mRight == null || getGrandparent(n).mLeft == null){
		return null;}//Checks all paths up the tree and see if any are null
        if(getGrandparent(n).mLeft.equals(n.mParent))
            return n.mParent.mParent.mRight;//if grenadparent == grandparent go get uncle
        return n.mParent.mParent.mLeft;
	}

	// Rotate the tree right at the given node.
    private void rotateRight(Node n) {
        Node l = n.mLeft, lr = l.mRight, p = n.mParent;
        n.mLeft = lr;
        lr.mParent = n;

        l.mRight = n;
        if (n == mRoot) {
            mRoot = l;
            l.mParent = null;
        }
        else if (p.mLeft == n) {
            p.mLeft = l;
            l.mParent = p;
        }
        else {
            p.mRight = l;
            l.mParent = p;
        }
        n.mParent = l;
    }

	// Rotate the tree left at the given node.
	private void rotateLeft(Node n) {
		// TODO: do a single left rotation (AVL tree calls this a "rr" rotation)
		// at n.
        Node r = n.mRight, rl = r.mLeft, p = n.mParent;
        n.mRight = rl;
        rl.mParent = n;

        r.mLeft = n;
        if (n == mRoot) {
            mRoot = r;
            r.mParent = null;
        }
        else if (p.mRight == n) {
            p.mRight = r;
            r.mParent = p;
        }
        else {
            p.mLeft = r;
            r.mParent = p;
        }
        n.mParent = r;
	}


	// This method is used by insert. It is complete.
	// Inserts the key/value into the BST, and returns true if the key wasn't
	// previously in the tree.
	private boolean bstInsert(Node newNode, Node currentNode) {
		if (mRoot == null) {
			// case 1
			mRoot = newNode;
			return true;
		}
		else{
			int compare = currentNode.mKey.compareTo(newNode.mKey);
			if (compare < 0) {
			// newNode is larger; go right.
				if (currentNode.mRight != NIL_NODE)
					return bstInsert(newNode, currentNode.mRight);
				else {
					currentNode.mRight = newNode;
					newNode.mParent = currentNode;
					mCount++;
					return true;
				}
			}
			else if (compare > 0) {
				if (currentNode.mLeft != NIL_NODE)
					return bstInsert(newNode, currentNode.mLeft);
				else {
					currentNode.mLeft = newNode;
					newNode.mParent = currentNode;
					mCount++;
					return true;
				}
			}
			else {
				// found a node with the given key; update value.
				currentNode.mValue = newNode.mValue;
				return false; // did NOT insert a new node.
			}
		}
	}
}
