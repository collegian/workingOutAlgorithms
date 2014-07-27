package bst.operations;

/*
 * TODO (s): (1) Make the class generic (challenge is to implement <, > operations on non-integer types, is it possible?)
 * (2) This impl doesn't store the parent, is it a good idea to do that?
 */

public final class BinarySearchTreeAndOps
{
	Node root;
	
	public BinarySearchTreeAndOps(Node root)
	{
		this.root=root;
	}
	
	public static class Node
	{
		int value;
		Node left;
		Node right;
		
		public Node(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return value;
		}
	}
	
	// TODO : This doesn't make use of the parent node.
	// Find out how to implement with parent Node? It seems it's possible to do it without passing it as an argument to this method.
	public void insertNode(Node x)
	{
		nodeInsertionHelper(x,root);
	}
	
	private void nodeInsertionHelper(Node x,Node root)
	{
		if(root == null)
		{
			root = x;
		}
		
		if(x.value <= root.value)
		{
			if(root.left==null)
			{
				root.left = new Node(x.value);
			}
			else
			{
				nodeInsertionHelper(x,root.left);
			}
		}
		else 
		{
			if(root.right == null)
			{
				root.right = new Node(x.value);
			}
			else
			{
				nodeInsertionHelper(x,root.right);
			}
		}
	}
	
	//Idea is to keep passing the parent of every node at each level.
	//TODO : This won't correctly identify the parent for a tree with non-unique nodes.
	public Node findParent(Node x,Node current,Node parent)
	{
		if(current == null)
		{
			return null;
		}
		
		if(x.value <= current.value)
		{
			if(current.value == x.value)
			{
				return parent;
			}
			else
			{
				return findParent(x,current.left,current);
			}
		}
		else
		{
			if(current.value == x.value)
			{
				return parent;
			}
			else
			{
				return findParent(x,current.right,current);
			}
		}
	}
	
	public void preOrderTraversal(Node x)
	{
	   if(x==null)
	   {
		   return;
	   }
	   
	   System.out.println(x.value);
       preOrderTraversal(x.left);
       preOrderTraversal(x.right);
	}
	
	public void inOrderTraversal(Node x)
	{
		if(x==null)
		{
			return;
		}
		
			inOrderTraversal(x.left);
		
		System.out.println(x.value);
		
			inOrderTraversal(x.right);
	}
	
	public void postOrderTraversal(Node x)
	{
	   if(x==null)
	   {
		   return;
	   }
	   
	   postOrderTraversal(x.left);
	   postOrderTraversal(x.right);
       System.out.println(x.value);
	}
	
	public Node inOrderPredecessor(Node x)
	{
		if(x.left!=null)
		{
			return findMax(x.left);
		}
		else
		{
			Node parent = findParent(x,root,root);
			Node superParent = findParent(parent,root,root);
			
			// If the node is on the right then parent is the predecessor
			if(x.value > parent.value)
			{
				return parent;
			}
			
			// If node is on left then parent's parent is the predecessor
			else
			{
				return superParent;
			}
		}
	}
	
	public Node findMax(Node x)
	{
		if(x.right!=null)
		{
		  return findMax(x.right);
		}
		
		return x;
	}
	
	public Node findMin(Node x)
	{
		if(x.left!=null)
		{
		  return findMin(x.left);
		}
		
		return x;
	}
}
