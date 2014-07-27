package bst.operations.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bst.operations.BinarySearchTreeAndOps;
import bst.operations.BinarySearchTreeAndOps.Node;

public class BinarySearchTreeAndOpsTest 
{
	Node[] nodes = new Node[]{new Node(15),new Node(6),new Node(7),new Node(3),new Node(2),new Node(4),new Node(13),new Node(9),new Node(18),new Node(17),new Node(20)};
	BinarySearchTreeAndOps bstOps = new BinarySearchTreeAndOps(nodes[0]);
	
	@Before
	public void setup()
	{
		bstOps.insertNode(nodes[1]);
		bstOps.insertNode(nodes[2]);
		bstOps.insertNode(nodes[3]);
		bstOps.insertNode(nodes[4]);
		bstOps.insertNode(nodes[5]);
		bstOps.insertNode(nodes[6]);
		bstOps.insertNode(nodes[7]);
		bstOps.insertNode(nodes[8]);
		bstOps.insertNode(nodes[9]);
		bstOps.insertNode(nodes[10]);
	}
	
	//TODO: Currently doing verification by inspection.
	@Test
	public void testInsertion() 
	{
		System.out.println("Post order traversal:");
		bstOps.postOrderTraversal(nodes[0]);
		
		System.out.println("In order traversal:");
		bstOps.inOrderTraversal(nodes[0]);
	}
	
	@Test
	public void testParent() 
	{
	  assertTrue(7==bstOps.findParent(nodes[6], nodes[0],nodes[0]).getValue());
	  assertTrue(18==bstOps.findParent(nodes[9], nodes[0],nodes[0]).getValue());
	}
	
	@Test
	public void testPredecessor()
	{
		 assertTrue(7==bstOps.inOrderPredecessor(nodes[7]).getValue());
		 assertTrue(13==bstOps.inOrderPredecessor(nodes[0]).getValue());
		 assertTrue(15==bstOps.inOrderPredecessor(nodes[9]).getValue());
		 assertTrue(18==bstOps.inOrderPredecessor(nodes[10]).getValue());
	}
}
